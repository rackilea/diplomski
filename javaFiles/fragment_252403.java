slider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
        ft.setFromValue(oldvalue.doubleValue());
        ft.setToValue(newvalue.doubleValue());
        ft.setNode(myImageView); //---> add this
        ft.play();
    });