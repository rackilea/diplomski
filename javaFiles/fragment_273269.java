NumberFormat numberFormat = NumberFormat.getNumberInstance(); // you can set a locale here
UnaryOperator<TextFormatter.Change> filter = change -> {
    String controlNewText = change.getControlNewText();
    if ("-".equals(controlNewText)) {
        return change;
    } else {
        try {
            numberFormat.parse(controlNewText);
            return change;
        } catch (ParseException | NullPointerException ignored) {
            return null;
        }
    }
};
StringConverter<Double> converter = new StringConverter<Double>() {
    @Override
    public Double fromString(String s) {
        try {
            return numberFormat.parse(s).doubleValue();
        } catch (ParseException ignored) {
            return 0.0;
        }
    }
    @Override
    public String toString(Double d) {
        return numberFormat.format(d);
    }
};
this.setTextFormatter(new TextFormatter<>(converter, 0.0, filter));