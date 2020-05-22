String query = ("UPDATE TB01 SET BLADETYPE=?,STARTT1=?,AIRT1=?,FOAMT1=?,SCT1=?,FINISHT1=? WHERE SERIAL=?");
try (PreparedStatement pstmt = conn.prepareStatement(query)) {
    pstmt.setString(7, bladeSerial);
    pstmt.setString(1, itemText);
    pstmt.setString(2, String.valueOf(startTime1));
    pstmt.setString(3, String.valueOf(airTime1));
    pstmt.setString(4, String.valueOf(foamTime1));
    pstmt.setString(5, String.valueOf(scTime1));
    pstmt.setString(6, String.valueOf(finishTime1));
    pstmt.executeUpdate();
                                                             }
catch (SQLException ex) {
    // Exception handling
    Logger.getLogger(FormTwo1.class.getName()).log(Level.SEVERE, null, ex);
                          }