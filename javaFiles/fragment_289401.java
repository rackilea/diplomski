Color[] colors = new Color[size]; // class variable - fill with appropriate colors
int curIndex = 0; // class variable

rect.setOnMouseClicked(event -> {
    curIndex = curIndex >= colors.length - 1 ? 0 : curIndex + 1;
    rect.setFill(colors[curIndex]);
});