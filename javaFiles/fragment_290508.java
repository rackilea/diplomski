private int rowCounter = 0;

...

plusButton.setOnAction(e -> {
    rowCounter = (rowCounter+1) % 4; // alternative using modulo here
    ta.setText(Integer.toString(rowCounter));
});
minusButton.setOnAction(e -> {
    rowCounter = (rowCounter + 3) % 4; // alternative using modulo
    ta.setText(Integer.toString(rowCounter));
});