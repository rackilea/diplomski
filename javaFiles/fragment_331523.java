ActionListener updater = new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
    jLabelNumber.setText(messages[i]);

    i++;
    if (i >= messages.length) {
      i = 0;
    }
  }

  private int i = 0;
};