secondsLabel.textProperty().bind(Bindings.createStringBinding(() -> {
    NumberFormat formatter = NumberFormat.getIntegerInstance();
    formatter.setMinimumIntegerDigits(2);
    if(sec.getValue() == null) {
        return "";
    }else {
        return formatter.format(sec.get());
    }
}, sec));