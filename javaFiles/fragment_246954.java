JRadioButton yesButton   = new JRadioButton("Yes", true);
JRadioButton noButton    = new JRadioButton("No", false);

ButtonGroup bgroup = new ButtonGroup();
bgroup.add(yesButton);
bgroup.add(noButton);

JPanel radioPanel = new JPanel();
radioPanel.setLayout(new GridLayout(2, 1));
radioPanel.add(yesButton);
radioPanel.add(noButton);

radioPanel.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "BorderTitle"));