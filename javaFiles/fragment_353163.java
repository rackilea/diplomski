Hyperlink hlink = new Hyperlink();
Image image = new Image(MyClass.class.getResourceAsStream("/images/close.png"));
hlink.setGraphic(new ImageView(image));
hlink.setFocusTraversable(false);
Tab tab = new Tab();
tab.setGraphic(hlink);
hlink.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
              //Do somthing
         }
});