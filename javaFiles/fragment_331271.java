musicButton.setOnAction(event -> {
    if (musicButton.isSelected()) {
        menuPlayer.pause();
    }else {
        menuPlayer.play();
    }
});