int lastId() {

    int newSheetNumber=0;
    String query = "SELECT MAX(ID) FROM SHEETSDB WHERE MONTH(`SHEETDATE`)=MONTH(NOW()) AND YEAR(`SHEETDATE`)=YEAR(NOW())";
    try {
        preparedStatement = conn.prepareStatement(query);

        rs = preparedStatement.executeQuery();
        if (!rs.next()) {
            newSheetNumber = 1;
        }else {
            newSheetNumber = rs.getInt(1) + 1;
        }
        preparedStatement.close();
        rs.close();
        //System.out.println("The new sheet is: " + newSheetNumber);
    } catch (SQLException ex) {
        System.err.println("Error " + ex);
    }
    return newSheetNumber;
}