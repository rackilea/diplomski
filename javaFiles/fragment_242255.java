// add JLabels to a JPanel that uses GridLayout set to have
// 1 column and "rows" number of rows.
JPanel labelHolder = new JPanel(new GridLayout(rows, 1);
lbl = new JLabel[rows];
for (int i = 0; i < rows; i++) {
  lbl[i] = new JLabel(arrayResultRow[i].toString());
  labelHolder.add(lbl[i]);
}