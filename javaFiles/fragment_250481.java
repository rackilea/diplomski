public class Gui {
  private JButton btnUpdate; // make private and non-static
  public Gui() {
    // JButton btnSearch = new JButton("Search");
    //  btnSearch.setBounds(463, 112, 91, 23); // don't use absolute positioning
    //  btnSearch.setVisible(true);  // not needed

    btnUpdate = new btnUpdate("Search");
    pnUpper.add(btnSearch);
 }

 public AbstractButton getBtnUpdate() {
    return btnUpdate;
 }
}