for (int i = 0; i < 5; i++) {
  TableRow tableRow = new TableRow(this);
  tableRow.addView(createTextView(listTipe.get(i).getType());
  tableRow.addView(createTextView(listTotal1.get(i).getTotal()));
  tableRow.addView(createTextView(listTotal2.get(i).getTotal()));
  tableRow.addView(createTextView(listTotal3.get(i).getTotal()));
  tableRow.addView(createTextView(listTotal1.get(i).getUang()));
  tableLayout.addView(tableRow);
}