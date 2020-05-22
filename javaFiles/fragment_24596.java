ToggleButton tb1 = new ToggleButton("ToggleButton1");
ToggleButton tb2 = new ToggleButton("ToggleButton2");

tb1.selectedProperty().addListener(((observable, oldValue, newValue) -> {
    System.out.println(tb1.getText() + " changed from " + oldValue + " to " + newValue);
    System.out.println("Taking a nap!");
}));

tb2.selectedProperty().addListener(((observable, oldValue, newValue) -> {
    System.out.println(tb2.getText() + " changed from " +oldValue + " to " + newValue);
    System.out.println("Working hard!");
}));