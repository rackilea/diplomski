public class CreditsScreen extends AbstractScreen {

    public CreditsScreen(final Game game) {
        super(game);

        // Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        uiSkin.add("white", new Texture(pixmap));

        // Store the default libgdx font under the name "default".
        BitmapFont buttonFont = new BitmapFont();
        buttonFont.scale(scale);
        uiSkin.add("default", buttonFont);

        // Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = uiSkin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = uiSkin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = uiSkin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = uiSkin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = uiSkin.getFont("default");
        uiSkin.add("default", textButtonStyle);

        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        uiStage.addActor(table);

        table.debug(); // turn on all debug lines (table, cell, and widget)
        table.debugTable(); // turn on only table lines

        // Label
        BitmapFont labelFont = new BitmapFont();
        labelFont.scale(scale);
        LabelStyle labelStyle = new LabelStyle(labelFont, Color.BLUE);
        uiSkin.add("presents", labelStyle);
        final Label myName = new Label("Credits and all that stuff", uiSkin, "presents");

        table.add(myName).expand().center();
    }
}