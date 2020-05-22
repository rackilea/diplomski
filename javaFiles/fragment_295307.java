Pane p = new Pane();
Button b = new Button("Clickable");
Circle c = new Circle(450, 450, 90, Color.RED);
c.setVisible(false);
EventHandler<ActionEvent> e = evt -> {
    c.setOnKeyPressed(g -> {
        if(g.getCode() == UP) {c.setCenterY(c.getCenterY() + 10);}
        if(g.getCode() == DOWN) {c.setCenterY(c.getCenterY() - 10);}
        if(g.getCode() == RIGHT) {c.setCenterX(c.getCenterX() + 10);}
        if(g.getCode() == LEFT) {c.setCenterX(c.getCenterX() - 10);}
    });
    c.setVisible(true);
    c.requestFocus();
};
b.setOnAction(e);
p.getChildren().addAll(b, c);
Scene s = new Scene(p, 900, 900);
stage.setScene(s);
stage.show();