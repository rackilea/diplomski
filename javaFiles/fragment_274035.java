DefaultTableModel dm = new DefaultTableModel(10, 10);
jTable1.setModel(dm);
while (rs5.next()) {
    String coursecode= rs5.getString(2);
    …
}