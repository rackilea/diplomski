public void commitEdit() throws ParseException {
    AbstractFormatter format = getFormatter();

    if (format != null) {
        setValue(format.stringToValue(getText()), false, true);
    }
}