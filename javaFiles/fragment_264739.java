int resort = Integer.parseInt(x);
//String sql = "SELECT RESORT_NAME FROM LouwDataBase.Resorts WHERE ID = ?";  
String sql = "SELECT RESORT_NAME FROM LouwDataBase.Resorts WHERE ID = " + resort;  
try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    //pstmt.setInt(1, resort);
    try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
            String resortName = rs.getString("RESORT_NAME");
            JOptionPane.showMessageDialog(null,
                "You want to book at " + resortName);
        }
    }
} catch (SQLException ex) {
    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
}