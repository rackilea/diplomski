public ExpensesPanel(String name, String date, int cost, int expense) {
  n = name;
  d = date;
  c = cost;
  e = expense;

  // Create new Panel and set it on horizontal axis
  // JPanel exp = new JPanel();
  setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
  Box horizontalBox;

  // Labels
  JLabel newName = new JLabel("Name: ", JLabel.CENTER);
  JLabel newDate = new JLabel("Date", JLabel.CENTER);
  JLabel newCost = new JLabel("Cost: ", JLabel.CENTER);
  JLabel newExp = new JLabel("Expense: ", JLabel.CENTER);
  add(newName, Box.createHorizontalGlue());
  add(newDate, Box.createHorizontalGlue());
  add(newCost, Box.createHorizontalGlue());
  add(newExp, Box.createHorizontalGlue());
}