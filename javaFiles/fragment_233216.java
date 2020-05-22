TextField depositInput = new TextField();
TextField withdrawInput = new TextField();
Button button = new Button("Execute");
button.setOnAction((event) -> {
    if (!depositInput.getText().isEmpty() && !withdrawInput.getText().isEmpty()) {
        System.out.println("Deposit&Withdrawal");
    } else if (!depositInput.getText().isEmpty()) {
        System.out.println("Deposit");
    } else if (!withdrawInput.getText().isEmpty()) {
        System.out.println("Withdrawal");
    }
});