public Button getMusicButton() {
    final Button button = new ImageButton(getMusicButtonStyle());
    button.setChecked(Prefs.isMusicOn());
    button.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            MusicHandler.getInstance().toggleMusic();
        }
    });
    return button;
}

private ImageButton.ImageButtonStyle getMusicButtonStyle() {
    ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
    style.up = musicOffDrawable;
    style.checked = musicOnDrawable;
    return style;
}