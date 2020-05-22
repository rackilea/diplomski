slider.valueProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
                           Number old_val, Number new_val) { 

            player.seek(Duration.seconds((double) new_val);

        }});