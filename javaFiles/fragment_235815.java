pane.setOnMouseClicked(
        (Event event) -> {    

    // process your click here

    System.out.println("Panel clicked");
    pane.requestFocus();
    event.consume();
};