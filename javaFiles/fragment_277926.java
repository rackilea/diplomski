String filename="foo.wav";
    Clip clip=AudioSystem.getClip();
    AudioInputStream inputStream=AudioSystem.getAudioInputStream(new BufferedInputStream(Audio.class.getResourceAsStream(filename)));
    if(inputStream!=null) {
        clip.open(inputStream);
        FloatControl gainControl=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f); // ?
        clip.start();
        // maybe do not wait?
        while(clip.getMicrosecondLength()!=clip.getMicrosecondPosition())
            Thread.yield(); // wait
        // or at least don't wait here?
        Thread.sleep(500);
        clip.close();
    }