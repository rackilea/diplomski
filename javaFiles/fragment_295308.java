Pane p = new Pane();
Scene s = new Scene(p, 900, 900);
Button b = new Button("Clickable");
Circle c = new Circle(450, 450, 90, Color.RED);
c.setVisible(false);
EventHandler<ActionEvent> e = evt -> {
    s.setOnKeyPressed(g -> {
        if(g.getCode() == UP) {c.setCenterY(c.getCenterY() + 10);}
        if(g.getCode() == DOWN) {c.setCenterY(c.getCenterY() - 10);}
        if(g.getCode() == RIGHT) {c.setCenterX(c.getCenterX() + 10);}
        if(g.getCode() == LEFT) {c.setCenterX(c.getCenterX() - 10);}
    });
    c.setVisible(true);
};
b.setOnAction(e);
p.getChildren().addAll(b, c);
stage.setScene(s);
stage.show();