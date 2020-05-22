// assume "main" is your current top-level container
main.setLayout(new BorderLayout());
main.add(rightPanel, BorderLayout.EAST);
JPanel leftColumn = new JPanel();
leftColumn.setLayout(new BorderLayout());
main.add(leftColumn, BorderLayout.CENTER);

leftColumn.add(bottomPanel, BorderLayout.SOUTH);
leftColumn.add(centerPanel, BorderLayout.CENTER);