private Component getRow(int numberOfColumns) {

    JPanel row = new JPanel();
    //use GridLayout if you want equally spaced columns 
    row.setLayout(new BoxLayout(row, BoxLayout.Y_AXIS));
    for (int colIndex = 0; colIndex < numberOfColumns; colIndex++) {
        row.add(getCell());
    }
    return row;
}