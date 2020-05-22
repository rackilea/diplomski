mediaPlayer.setOnPlaying(()-> {
    Thread th = new Thread() {
        @Override
        public void run() {
            Duration a;
            while (mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Shit aint workin bro");
                }
                a = mediaPlayer.getCurrentTime();
                int currentTime = (int) a.toSeconds();
                System.out.println(currentTime);
                Platform.runLater(() -> durationSlider.setValue(50.0));  //Testing the setValue() method

        }
    };
    th.start();
});