JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
  NoRepeatButtonGroup noRepeatButtonGroup = new NoRepeatButtonGroup();

  JButton yesButton = new JButton(new YesAction());
  noRepeatButtonGroup.add(yesButton);
  buttonPanel.add(yesButton);

  JButton noButton = new JButton(new NoAction());
  noRepeatButtonGroup.add(noButton);
  buttonPanel.add(noButton);

  JButton maybeButton = new JButton(new MaybeAction());
  noRepeatButtonGroup.add(maybeButton);
  buttonPanel.add(maybeButton);