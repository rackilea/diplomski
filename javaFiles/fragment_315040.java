...
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(af, audio, 0, size);
        clip.loop(3); //Added this line
        clip.setLoopPoints(0, -1); //Added this line
        clip.start();
        ...