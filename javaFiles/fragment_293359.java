rootPane.setOnMouseClicked(e -> {
        if (e.getButton() == MouseButton.PRIMARY) {
            if (currentPolygon == null) {
                currentPolygon = new Polygon();
                currentPolygon.getPoints().addAll(e.getX(), e.getY());
                currentPolygon.setStroke(Color.BLACK);
                rootPane.getChildren().add(currentPolygon);
            }
            currentPolygon.getPoints().addAll(e.getX(), e.getY());
        } else {
            currentPolygon = null ;
        }
    });
    rootPane.setOnMouseMoved(e -> {
        if (currentPolygon != null) {
            currentPolygon.getPoints().set(currentPolygon.getPoints().size()-2, e.getX());
            currentPolygon.getPoints().set(currentPolygon.getPoints().size()-1, e.getY());
        }
    });