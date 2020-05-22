private final List<MediaPlayer> playList = new ArrayList<>();

public void createMediaList() {
    for(String file : filterFiles()) {
        MediaPlayer player=createPlayer(file);
        if(player!=null){
            playList.add(player);
        }
    }
    if(playList.isEmpty()) {
        System.out.println("No se han encontrado archivos multimedia");
        Platform.exit();
        return;
    }
    // start first track
    nextMedia();
}