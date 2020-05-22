try {
    PreparedStatement stm= (PreparedStatement) con.prepareStatement("INSERT INTO d (dateEntré) VALUES(?)");

    stm.setDate(1,convertUtilDateToSqlDate(dateChooser.getDate()));
    int rows = statement.executeUpdate();
    if (rows > 0) { // Should be 1
        JOptionPane.showMessageDialog(null,"added");
    } else {
        JOptionPane.showMessageDialog(null,"Update failed for unknown reason");
    }
} catch (Exception e1) {
    JOptionPane.showMessageDialog(null,e1.getMessage());
    e1.printStackTrace();
}