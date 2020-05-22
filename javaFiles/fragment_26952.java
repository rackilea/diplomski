private void actionPerformed(java.awt.event.ActionPerformed e) {
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    model.setRorCount(0);
    A a = new A();
    String[][] students = a.getStudents();
    for (String[] row : students) {
        model.addRow(row);
    }
}