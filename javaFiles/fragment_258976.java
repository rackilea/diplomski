public double getBase() {
    String text = logBase.getText();
    if (text.trim().isEmpty()) {
        text = "0";
    }
    return Double.parseDouble(text);
}

public double getNumber() {
    String text = logNum.getText();
    if (text.trim().isEmpty()) {
        text = "0";
    }
    return Double.parseDouble(text);
}