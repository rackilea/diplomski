plusButton.setOnAction(e->{
    ta.setText(Integer.toString(rowCounter.updateAndGet(i -> i >= 3 ? 0 : i+1)));
});
minusButton.setOnAction(e->{
    ta.setText(Integer.toString(rowCounter.updateAndGet(i -> i <= 0 ? 3 : i-1)));
});