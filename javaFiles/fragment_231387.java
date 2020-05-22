public void buttonClick(ClickEvent event) {
    floatValue = Float.parseFloat(textfield.getValue());
    intValue = Math.round(floatValue);
    stringValue = String.valueOf(intValue);
    textfield.setCaption(stringValue);
}