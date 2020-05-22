for (String row : fileContents) {
    pstvisit.clearParameters();

    String[] rowData = row.split(",");

    int docNumber = Integer.valueOf(rowData[0]);
    int patNumber = Integer.valueOf(rowData[1]);
    String date = row[2];
    int price = Integer.valueOf(row[3]);

    pstvisit.setInt(1, docNumber);
    pstvisit.setInt(2, patNumber);
    pstvisit.setString(3, date);
    pstvisit.setInt(4, price);

    pstvisit.executeUpdate();
}