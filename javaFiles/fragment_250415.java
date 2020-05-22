Table scrollableTable = new Table(skin);
scrollableTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

for(WeaponElement weapon : GameScreen.dataLoader.getWeaponArray()){
    final TextButton button = new TextButton(wapon.name, skin, "default");
    button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            // do stuff
        });
    scrollableTable.add(button).center();

    // add a picture
    Image img = new Image(new Texture(weapon.getIconPath()));
    scrollableTable.add(img).width(32);

    // finish a row
    scrollableTable.row();
}