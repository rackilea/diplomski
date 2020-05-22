TextField name = new TextField();
Paragraph greeting = new Paragraph("");
Button button = new Button("Result", event -> {
    int num;
    try {
        num = Integer.parseInt(String.valueOf(name.getValue()));
    } catch (NumberFormatException e) {
        num = 0; // your default value
        // you should also let the user know he didnt enter a valid number
        Notification.show("Please enter a valid number");
    }
    greeting.setText(" " + num * 500);
});
add(name, button, greeting);