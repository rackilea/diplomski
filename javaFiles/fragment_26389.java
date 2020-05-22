NumberStringConverter converter = new NumberStringConverter();
TextFormatter<Number> formatter = new TextFormatter<>(converter);
params.rateProperty().addListener(
    (o, old, rate) -> formatter.setValue(rate.doubleValue() / DIVISOR.get()));
formatter.valueProperty().addListener(
    (o, old, rate) -> params.setRate(rate.doubleValue() * DIVISOR.get()));

rateTextField.setTextFormatter(formatter);