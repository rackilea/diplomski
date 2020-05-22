secondsLabel.textProperty().bind(Bindings.createStringBinding(() -> {
    if(sec.getValue() == null) {
        return "";
    }else {
        return String.format("%02d", sec.getValue());
    }
}, sec));