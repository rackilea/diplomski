private static final int DIVISOR = 32;

// ...

NumberStringConverter converter = new NumberStringConverter();
TextFormatter<Number> formatter = new TextFormatter<>(converter);
params.rateProperty().addListener(
    (o, old, rate) -> formatter.setValue(rate.doubleValue() / DIVISOR));
formatter.valueProperty().addListener(
    (o, old, rate) -> params.setRate(rate.doubleValue() * DIVISOR));

rateTextField.setTextFormatter(formatter);