for (i = 1; i < 65; i++) {
    squareArray[i] = i;

    JButton b=new JButton("" + squareArray[i]);
    b.setBackground(desiredColorHere);
    frame.add(b);
}