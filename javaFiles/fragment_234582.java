public static void main(String[] args) throws FileNotFoundException, IOException {
    File file = new File(TEST_FOLDER, "Test.txt");
    //These settings create a 122 MB file.
    generateTestFile(file, 500000, 50);

    long clock = System.nanoTime();
    processChunks(file, 8 * (int) Math.pow(1024, 2));
    clock = System.nanoTime() - clock;
    float millis = clock / 1000000f;
    float seconds = millis / 1000f;
    System.out.printf(""
                    + "%12d nanos\n"
                    + "%12.3f millis\n"
                    + "%12.3f seconds\n",
                    clock, millis, seconds);
}

public static File prepareResultFile(File source) {
    String ofn = source.getName(); //Original File Name.
    int extPos = ofn.lastIndexOf('.'); //Extension index.
    String ext = ofn.substring(extPos); //Get extension.
    ofn = ofn.substring(0, extPos); //Get name without extension reusing 'ofn'.
    return new File(source.getParentFile(), ofn + "_Result" + ext);
}

public static void processChunks(File file, int buffSize)
                throws FileNotFoundException, IOException {
    //No need for buffers bigger than the file itself.
    if (file.length() < buffSize) {
        buffSize = (int)file.length();
    }
    byte[] buffer = new byte[buffSize];
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file), buffSize);

    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
                    prepareResultFile(file)), buffSize);

    StringBuilder sb = new StringBuilder();
    while (bis.read(buffer) > (-1)) {
        //Check if a "\r\n" was split between chunks.
        boolean skipFirst = false;
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\r') {
            if (buffer[0] == '\n') {
                bos.write(("\\r\\n: " + sb.toString() + System.lineSeparator()).getBytes());
                sb = new StringBuilder();
                skipFirst = true;
            }
        }

        for (int i = skipFirst ? 1 : 0; i < buffer.length; i++) {
            if (buffer[i] == '\r') {
                if (i + 1 < buffer.length) {
                    if (buffer[i + 1] == '\n') {
                        bos.write(("\\r\\n: " + sb.toString() + System.lineSeparator()).getBytes());
                        i++; //Skip '\n'.
                    } else {
                        bos.write(("\\r: " + sb.toString() + System.lineSeparator()).getBytes());
                    }
                    sb = new StringBuilder(); //Reset accumulator.
                } else {
                    //A "\r\n" might be split between two chunks.
                }
            } else if (buffer[i] == '\n') {
                bos.write(("\\n: " + sb.toString() + System.lineSeparator()).getBytes());
                sb = new StringBuilder(); //Reset accumulator.
            } else {
                sb.append((char) buffer[i]);
            }
        }
    }
    bos.write(("EOF: " + sb.toString()).getBytes());
    bos.flush();
    bos.close();
    bis.close();
    System.out.println("Finished!");
}

public static boolean generateTestFile(File file, int lines, int elements)
                throws IOException {
    String[] lineBreakers = {"\r", "\n", "\r\n"};
    BufferedOutputStream bos = null;
    try {
        bos = new BufferedOutputStream(new FileOutputStream(file));
        for (int i = 0; i < lines; i++) {
            for (int ii = 1; ii < elements; ii++) {
                bos.write("test ".getBytes());
            }
            bos.write("test".getBytes());
            bos.write(lineBreakers[i % 3].getBytes());
        }
        bos.flush();
        System.out.printf("LOG: Test file \"%s\" created.\n", file.getName());
        return true;
    } catch (IOException ex) {
        System.err.println("ERR: Could not write file.");
        throw ex;
    } finally {
        try {
            bos.close();
        } catch (IOException ex) {
            System.err.println("WRN: Could not close stream.");
            Logger.getLogger(Q_13458142_v2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}