public ButtonEditor(JButton button) {
    super(new JCheckBox());
    this.button = button;
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }