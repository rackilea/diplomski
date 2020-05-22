UnaryOperator<Change> integerFilter = change -> {
    String newText = change.getControlNewText();
    if (newText.matches("-?([1-9][0-9]*)?")) { 
        return change;
    }
    return null;
};

myNumericField.setTextFormatter(
    new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));