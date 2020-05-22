textField.setFont(textField.getFont().deriveFont(BTN_FONT_SIZE));

  mainPanel.setLayout(new BorderLayout(gap, gap));
  mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
  mainPanel.add(textField, BorderLayout.PAGE_START);
  mainPanel.add(buttonPanel, BorderLayout.CENTER);