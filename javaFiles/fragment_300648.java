if (source.equals(input.getDocument())) {
    try {
        input.commitEdit();
        double temp = ((Number) input.getValue()).doubleValue();
        temp = converter(temp);
        input2.setValue(temp);
    } catch (ParseException ex) {
    }