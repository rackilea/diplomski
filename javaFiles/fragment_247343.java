String sql = "SELECT book_name, book_author, book_price FROM books WHERE id=?";
Statement ps = con.createStatement();
ps.setString(1, str1);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    String bookName = rs.getString("book_name");
    // etc.
}