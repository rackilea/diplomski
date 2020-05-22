private void setLocGrid() {
    if (curX == 11) // maximum component to be display in 1 row is 11
    {
        curY += 1;
        curX = 0;
    }

    cons.gridx = curX;
    cons.gridy = curY;
    cons.anchor = GridBagConstraints.FIRST_LINE_START;
    //cons.weightx = 1.0;
    //cons.weighty = 1.0;

    curX += 1;
}