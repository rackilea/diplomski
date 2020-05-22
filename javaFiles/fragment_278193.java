sampleRateSlider.valueProperty().addListener((ov, old_val, new_val) -> {
    int value = (int) Math.round(new_val.doubleValue());
    sampleRateSlider.setValue(value);
    System.out.println(value);
    sampleRateValueLabel.setText(getDisplayString(value));
});