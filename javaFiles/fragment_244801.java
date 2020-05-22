MenuBar menuBar = new MenuBar();

Menu menu = new Menu("Menu 1");

RadioMenuItem choice1Item = new RadioMenuItem("Choice 1");
choice1Item.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        System.out.println("radio toggled");
    }
});
RadioMenuItem choice2Item = new RadioMenuItem("Choice 2");
RadioMenuItem choice3Item = new RadioMenuItem("Choice 3");

ToggleGroup toggleGroup = new ToggleGroup();
toggleGroup.getToggles().add(choice1Item);
toggleGroup.getToggles().add(choice2Item);
toggleGroup.getToggles().add(choice3Item);

menu.getItems().add(choice1Item);
menu.getItems().add(choice2Item);
menu.getItems().add(choice3Item);

menuBar.getMenus().add(menu);

VBox vBox = new VBox(menuBar);

Scene scene = new Scene(vBox, 300, 275);
primaryStage.setScene(scene);
primaryStage.show();