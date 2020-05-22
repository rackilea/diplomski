for (int r = 0; r < 3; r++) {
    for (int c = 0; c < 3; c++) {
        int number = 3 * r + c;
        Button button = new Button(String.valueOf(number));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ((Button)e.getSource()).setText("Accepted");
            }
        });
        gridPane.add(button, c, r);
    }
}