try{
        File file = new File (fileName);
        AudioClip clip = Applet.newAudioClip(file.toURL());
        clip.loop();
        clip.stop();
    }
    catch(Exception e){
        e.printStackTrace();
    }