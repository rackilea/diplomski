/*
    ArrayList<Circle> moreCircles = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {
        new Circle(circle.getRadius() - (i * 5)).setFill(Color.color(Math.random(), Math.random(), Math.random(), 1));
    }
    */

    btn4.setOnAction(e -> {
        for (int i = 1; i <= 10; i++) {
            sp.getChildren().add(new Circle(circle.getRadius() - (i*5), Color.color(Math.random(), Math.random(), Math.random(), 1)));
        }
    });