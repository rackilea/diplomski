public final class AdminGUI extends System1 {
   public AdminGUI(DefaultTableModel userTableModelClone) {
        JTable adminTable = new JTable(userTableModelClone);
        adminTable.setModel(userTableModelClone);

}
}