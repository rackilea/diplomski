DefaultTableModel model = (DefaultTableModel) DisplayRecieveTB.getModel();
DisplayRecieveTB.revalidate();
model.getDataVector().removeAllElements();

try {

    Date date = DateChooserRS.getDate();

    try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM supplyrecievable where recievedate = ?")) {
        // You can also use a java.sql.Timestamp if the column is of the correct type
        stmt.setDate(1, new java.sql.Date(date.getTime()));
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String r1 = rs.getString("itemname");
                String r2 = rs.getString("itemgroup");
                String r3 = rs.getString("itemcount");
                String r4 = rs.getString("totalcost");
                String r5 = rs.getString("itemcode");
                model.addRow(new Object[]{r5, r1, r2, r3, r4});
                // This is pointless, as the model should notifty the table it needs to be updated
                //DisplayRecieveTB.revalidate();

            }
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}