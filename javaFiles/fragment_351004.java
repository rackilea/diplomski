Lab3Label[] label = new Lab3Label[9];
for (int i = 0; i < 9; i++) {
    label[i] = new Lab3Label(i);
    label[i].setHorizontalTextPosition(SwingConstants.CENTER);
    label[i].setVerticalTextPosition(SwingConstants.CENTER);
    add(label[i]);
}