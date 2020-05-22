public Song(File file) {
    music = new Media(file.toURI().toString());

    music.getMetadata().addListener((Change<? extends String, ? extends Object> c) -> {
        if (c.wasAdded()) {
            if ("artist".equals(c.getKey())) {
                artist = c.getValueAdded().toString();
            } else if ("title".equals(c.getKey())) {
                title = c.getValueAdded().toString();
            } else if ("album".equals(c.getKey())) {
                album = c.getValueAdded().toString();
            }
        }
    });

    mp = new MediaPlayer(music);

}