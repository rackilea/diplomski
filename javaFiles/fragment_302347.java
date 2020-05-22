//outside your method: construct this only once and reuse inside your method
pstm = con.prepareStatement("SELECT id, book, author FROM books WHERE isbn LIKE ?");

//in your method:
pstm.setString(1, "%" + fieldIsbn.getText() + "%" );
rs = pstm.executeQuery();