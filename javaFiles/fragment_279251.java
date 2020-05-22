int newRed = btnR.getBackground().getRed();
updateRed(newRed);


private void updateRed(int r){
    int g = bottomPanel.getBackground().getGreen();
    int b = bottomPanel.getBackground().getBlue();
    updateColor(r, g, b);
}

private void updateColor(int r, int g, int b){
    bottomPanel.setBackground(new Color(r, g, b));
}