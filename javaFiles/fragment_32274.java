Connection conn = null;
PreparedStatement pstmt = null;

float floatValue1 = 11.1;
float floatValue2 = 12.1;

try {
    conn = getConnection();
    String insertQuery = "INSERT INTO tablename (x_coord, y_coord)"
                        +"VALUES"
                        +"(?, ?)";
    pstmt = conn.prepareStatement(insertQuery);
    pstmt.setFloat(1, floatValue1);
    pstmt.setFloat(2, floatValue2);
    int rowCount = pstmt.executeUpdate();
    System.out.println("rowCount=" + rowCount);
} finally {
    pstmt.close();
    conn.close();
}