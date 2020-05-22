JPanel gameBoard = new JPanel();
gameBoard.setLayout(new GridLayout(3, 3, 8, 8));
gameBoard.add((one = createButton()));
gameBoard.add((two = createButton()));
gameBoard.add((three = createButton()));
gameBoard.add((four = createButton()));
gameBoard.add((five = createButton()));
gameBoard.add((six = createButton()));
gameBoard.add((seven = createButton()));
gameBoard.add((eight = createButton()));
gameBoard.add((nine = createButton()));
//one.setPreferredSize(new Dimension(150, 150));

//...

protected JButton createButton() {
    JButton btn = new JButton();
    btn.setMargin(new Insets(50, 50, 50, 50));
    return btn;
}