for(String file : filterFiles()) {
    playList.add(createPlayer(file));
}

private MediaPlayer createPlayer(String filePath) {
    Media media = new Media(new File(dir.toString()+"/"+filePath).toURI().toString());
    MediaPlayer player = new MediaPlayer(media);
    this.attachListeners(player);
    return player;
}