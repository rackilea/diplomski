model.addTableModelListener(new TableModelListener() {
  @Override public void tableChanged(final TableModelEvent e) {
    // TO DO: replace 100 with the actual preferred height.
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        table.setRowHeight(e.getFirstRow(), 100);
      }
    });
  }
});