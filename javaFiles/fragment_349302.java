clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {

                 // open the sound file as a Java input stream
                 String fileLocation = "";
                 InputStream in = new FileInputStream(gongFile);

                 // create an audiostream from the inputstream
                 AudioStream audioStream = new AudioStream(in);

                 // play the audio clip with the audioplayer class
                 AudioPlayer.player.start(audioStream);
            }
        });