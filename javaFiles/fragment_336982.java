@FXML
    private TextField numberscreen;

public void AudioPlay() {
        filestring = new File("src\\audio\\" + numberscreen.getText().trim() + ".wav");
        Media file = new Media(filestring.toURI().toString());

        mp = new MediaPlayer(file);

        mp.setOnReady(new Runnable() {
            @Override
            public void run() {
                System.out.println("Duration: " + file.getDuration().toMinutes());
                // display media's metadata
                file.getMetadata().entrySet().forEach((entry) -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                    mp.seek(Duration.millis(200));
                });
                mp.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                        mp.stop();
                        if (mp.isAutoPlay()) {
                            //Plays the subsequent files
                        }
                        return;
                    }
                });
                // play if you want
                mp.play();

            }
        });

    }