public void valueChanged(ListSelectionEvent e) {
    if (e.getSource() == jTable1.getSelectionModel()) {
      System.out.println("Event occurred in table 1");
    } else if (e.getSource() == jTable2.getSelectionModel()) {
      System.out.println("Event occurred in for table 2");
    }
}