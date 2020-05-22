for (XYChart.Series<Number, Number> series : bc.getData()) {
        for (XYChart.Data<Number, Number> data : series.getData()) {
            Node bubble = data.getNode();
            if (bubble != null && bubble instanceof StackPane) {
                StackPane region = (StackPane) bubble;
                if (region.getShape() != null && region.getShape() instanceof Ellipse) {
                    Ellipse ellipse = (Ellipse) region.getShape();
                    DoubleProperty fontSize = new SimpleDoubleProperty(10);

                    Label label = new Label(series.getName());
                    label.setAlignment(Pos.CENTER);
                    label.minWidthProperty().bind(ellipse.radiusXProperty());
                    //fontSize.bind(Bindings.when(ellipse.radiusXProperty().lessThan(40)).then(6).otherwise(10));
                    fontSize.bind(Bindings.divide(ellipse.radiusXProperty(), 5));
                    label.styleProperty().bind(Bindings.concat("-fx-font-size:", fontSize.asString(), ";"));
                    region.getChildren().add(label);
                }
            }
        }
    }