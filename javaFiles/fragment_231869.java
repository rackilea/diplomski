JLabel commandLabel = new JLabel(command);
    JLabel paramLabel = new JLabel(params);
    JLabel descLabel = new JLabel("<html><body style='width: 200px;'>" + description + "</body></html>");
    Font baseFont = commandLabel.getFont(), commandFont, paramFont, descFont;

    commandFont = baseFont.deriveFont(Font.BOLD);
    paramFont = baseFont.deriveFont(Font.ITALIC);
    descFont = baseFont.deriveFont(Font.PLAIN);

    commandLabel.setFont(commandFont);
    paramLabel.setFont(paramFont);
    descLabel.setFont(descFont);
    descLabel.setAlignmentX(LEFT_ALIGNMENT);
    descLabel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));   
    JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel descPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));// added
    headerPanel.add(commandLabel);
    headerPanel.add(paramLabel);

    descPanel.add(descLabel);// added

    this.add(headerPanel);
    this.add(descPanel);// modified