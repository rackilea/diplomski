scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double dif =oldValue.doubleValue()-newValue.doubleValue();
                buffer.setPrefWidth(buffer.getWidth()-(dif));
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double dif =oldValue.doubleValue()-newValue.doubleValue();
                buffer.setPrefHeight(buffer.getHeight()-(dif));
            }
        });