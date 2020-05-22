public void show()
{
    buttonsAtlas = new TextureAtlas("spellButton.pack"); //button atlas image
    buttonSkin = new Skin();
    buttonSkin.addRegions(buttonsAtlas);
    font = new BitmapFont(Gdx.files.internal("WhiteAlpha.fnt"), false); //the font

    stage = new Stage(); // window is stage
    stage.clear();

    TextButton.TextButtonStyle ribbonStyle = new TextButton.TextButtonStyle(); //Shop title ribbon properties
    ribbonStyle.up = buttonSkin.getDrawable("ribbon");
    ribbonStyle.down = buttonSkin.getDrawable("ribbon");
    ribbonStyle.font = font;

    // change it here (per style)
->  ribbonStyle.fontColor = Color.WHITE;

    ribbon = new TextButton("SHOP", ribbonStyle);  //shop title outlook adn textstyle
    ribbon.setPosition(200, 1720);
    ribbon.setSize(880, 200);

    // or, you can change it here (per button)
->  ribbon.setColor(Color.WHITE); 

}