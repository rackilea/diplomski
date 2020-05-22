timeSlider.setOnMousePressed(e -> {
    StackPane p = (StackPane)timeSlider.lookup(".thumb");
    System.out.println(p.getBoundsInParent().getMinX() + " " + p.getBoundsInParent().getMaxX() + " " + p.getWidth());
    double x = p.getBoundsInParent().getMinX() + ((p.getBoundsInParent().getMaxX()-p.getBoundsInParent().getMinX())/2);
    System.out.println(x);
    Line line = new Line(x,0,x,100);
    line.setFill(Color.RED);
    line.setStroke(Color.RED);
    line.getStyleClass().clear();
    group.getChildren().add(line);
    System.out.println(line.getBoundsInParent());

    if(!line.isVisible())
        line.setVisible(true);
});

<VBox prefHeight="126.0" prefWidth="600.0">
    <children>
        <Slider fx:id="timeSlider" maxWidth="1.7976931348623157E308" prefHeight="14.0" prefWidth="600.0" />
        <Pane fx:id="group" />
    </children>
</VBox>