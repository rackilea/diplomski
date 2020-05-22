InputStream is = null;//Actual InputStream here

        Clip clip = AudioSystem.getClip();

        clip.open(AudioSystem.getAudioInputStream(is));
        clip.start();