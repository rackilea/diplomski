int machCode = 1721;
String sql = "select TimeOn from PRODUCTIONS_MONITOR where MachCode = ?";
try (PreparedStatement pst = con.prepareStatement(sql)) {
    pst.setInt(1, machCode);
    try (ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
            arrCount.add(rs.getInt(1));
        }
    }
}
// rest of code here