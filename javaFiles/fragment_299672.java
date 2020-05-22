public void setup(Stage stg) {

    Node node = mainField.lookup(".top-toolbar");
    if (node instanceof ToolBar) {
        ToolBar bar = (ToolBar) node;

        ImageView graphic = new ImageView(new Image("save.png", 32, 16, true, true));
        graphic.setEffect(new DropShadow());
        Button b2 = new Button("", graphic);
        b2.setOnAction(e -> {
            save(stg);
        });
        bar.getItems().add(b2);

        ImageView iv = new ImageView(new Image("load.png", 32, 16, true, true));
        iv.setEffect(new DropShadow());
        Button b1 = new Button("", iv);
        b1.setOnAction(e -> {
            load();
        });
        bar.getItems().add(b1);
    }
}