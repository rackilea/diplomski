short[] audioData1 = null;
    short[] audioData2 = null;

    int n = 0;

    try {
        DataInputStream in1;
        in1 = new DataInputStream(new FileInputStream("v1.wav"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {

            while ((n = in1.read()) != -1) {
                bos.write(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer bb = ByteBuffer.wrap(bos.toByteArray());
        bb.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer sb = bb.asShortBuffer();
        audioData1 = new short[sb.capacity()];

        for (int i = 0; i < sb.capacity(); i++) {
            audioData1[i] = sb.get(i);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        DataInputStream in1;
        in1 = new DataInputStream(new FileInputStream("v2.wav"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {

            while ((n = in1.read()) != -1) {
                bos.write(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer bb = ByteBuffer.wrap(bos.toByteArray());
        bb.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer sb = bb.asShortBuffer();
        audioData2=  new short[sb.capacity()];

        sb.get(audioData2);


        System.out.println();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // find the max:
    float max = 0;
    for (int i = 22; i < audioData1.length; i++) {
        if (Math.abs(audioData1[i] + audioData2[i]) > max)
            max = Math.abs(audioData1[i] + audioData2[i]);
    }

    System.out.println("" + (Short.MAX_VALUE - max));

    int a, b, c;

    // now find the result, with scaling:
    for (int i = 22; i < audioData1.length; i++) {
        a = audioData1[i];
        b = audioData2[i];

        c = Math.round(Short.MAX_VALUE * (audioData1[i] + audioData2[i])
                / max);

        if (c > Short.MAX_VALUE)
            c = Short.MAX_VALUE;
        if (c < Short.MIN_VALUE)
            c = Short.MIN_VALUE;


        audioData1[i] = (short) c; 

    }

    // to turn shorts back to bytes.
    byte[] end = new byte[audioData1.length * 2];
    ByteBuffer.wrap(end).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(audioData1);

    try {
        OutputStream out  = new FileOutputStream("mixer.wav");

        for (int i = 0; i < end.length; i++) {
            out.write(end[i]);
            out.flush();
        }

        out.close();

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}