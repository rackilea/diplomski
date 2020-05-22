sp.vvalueProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) {
                fileName.setText(imageNames[(new_val.intValue() - 1)/100]);
                sp.snapshot(new SnapshotParameters(), new WritableImage(1, 1));
        }
    });