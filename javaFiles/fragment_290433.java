Button btn = new Button();
btn.setText("_Say 'Hello World'");
btn.setMnemonicParsing(true);
btn.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});