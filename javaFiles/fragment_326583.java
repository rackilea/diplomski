rect1.setOnMouseEntered(new EventHandler<MouseEvent>() {
public void handle(MouseEvent me) {
    rect1.setFill(Color.RED); 
}
});

rect1.setOnMouseExited(new EventHandler<MouseEvent>() {
public void handle(MouseEvent me) {
    rect1.setFill(Color.BLUE); 
}
});