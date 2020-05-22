pane.setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.UP) {
        pt.setRate((pt.getRate() + .03));
    } else if (e.getCode() == KeyCode.DOWN) {
        pt.setRate(pt.getRate() - 0.03);
    }
});