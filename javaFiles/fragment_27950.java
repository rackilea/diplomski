Line line = new Line(0, 40, 150, 40);
        Shape rect = new Rectangle(150, 150);

        Shape combined = Shape.subtract(rect,line);
        combined.setFill(Color.WHITE);
        combined.setStroke(Color.BLACK);

        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(4);

        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        line.setFill(Color.BLACK);

        pane.getChildren().add(combined);