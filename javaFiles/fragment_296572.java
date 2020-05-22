final Timer timer = new Timer(threshold, new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    filter.setSearchText(searchText.getText());
    viewer.refresh();
  }
});
timer.setRepeat(false);
searchText.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(final KeyEvent ke) {
        timer.restart();
    }
});