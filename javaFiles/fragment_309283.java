DigitPane[] hourDigit = new DigitPane[]{new DigitPane(), new DigitPane()};
DigitPane[] minDigit = new DigitPane[]{new DigitPane(), new DigitPane()};
DigitPane[] secDigit = new DigitPane[]{new DigitPane(), new DigitPane()};

JPanel digitsPanel = new JPanel(new GridBagLayout());
digitsPanel.add(hourDigit[0]);
digitsPanel.add(hourDigit[1]);
digitsPanel.add(new ColonPane());
digitsPanel.add(minDigit[0]);
digitsPanel.add(minDigit[1]);
digitsPanel.add(new ColonPane());
digitsPanel.add(secDigit[0]);
digitsPanel.add(secDigit[1]);