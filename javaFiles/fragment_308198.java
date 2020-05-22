String query = "INSERT INTO BOOKING(MEMBERID, NAME, CONTACT, "
        + "EMAILADDRESS, RESERVATIONDATE, RESERVATIONTIME) "
        + "VALUES(?, ?, ?, ?, ?, ?)";

try (Connection con = DriverManager.getConnection(url, username, password);
     PreparedStatement ps = con.prepareStatement(query)) {

    ps.setString(1, txtMemberID.getText());
    ps.setString(2, txtName.getText());
    ps.setString(3, txtContact.getText());
    ps.setString(4, txtEmail.getText());
    ps.setDate(5, new java.sql.Date(comboDate.getDate().getTime()));
    ps.setString(6, comboTime.getSelectedItem().toString());

    ps.executeUpdate();

    JOptionPane.showMessageDialog(null, "Booking created");

    /*clear the UI components etc.*/

} catch(SQLException ex) {
    JOptionPane.showMessageDialog(null, ex.toString(), JOptionPane.ERROR_MESSAGE);
}