if (ball.getBall().getCenterY() == 0) {
    //computer lost!

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(null);
    alert.setHeaderText(null);
    alert.setContentText("Good game. You won! Click OK to exit.");

    alert.setOnHidden(evt -> Platform.exit());

    alert.show(); 
}