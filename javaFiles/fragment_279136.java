private void attachListeners(MediaPlayer player) {
    ...
    player.getMedia().getMetadata().addListener(metadataListener);
    ...
    player.setOnEndOfMedia(() -> {
        player.getMedia().getMetadata().removeListener(metadataListener);
        player.stop();
        nextMedia();
    });
}