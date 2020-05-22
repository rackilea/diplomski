LabelStyle labelStyle = new LabelStyle();
labelStyle.font = yourBitmapFont;    

Label label = new Label("Hello world!", labelStyle);
dialog.text(label);
// You can also use: dialog.text("Hello world!", labelStyle)