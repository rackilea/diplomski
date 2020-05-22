class ToolBar extends JToolBar {

  makeButtons() {
    save = new JButton();
    // Icon and tooltip code
    save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        saveButtonPressed(event);
      }
    });
  }

  protected void saveButtonPressed(ActionEvent event) {}
}