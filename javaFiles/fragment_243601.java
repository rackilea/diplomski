public Game(Button button) {
    EventHandler<ActionEvent> current = button.getOnAction();
    button.setOnAction(e -> {
        current.handle(e);
        System.out.println("additional action");
    });
}