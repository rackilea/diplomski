public void VisibleSI() {
    if (tipo != 0) {
        throw new IllegalStateException();
    }
    for (JLabel i: lab) i.setVisible(true);
}