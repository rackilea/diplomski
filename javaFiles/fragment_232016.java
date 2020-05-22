Statement stmt = conn.createStatement();
String query = "SELECT b.ISBN, b.TITLE, COUNT(*) FROM BOOKS b JOIN BOOK_SUBJECT bs ON bs.ISBN = b.ISBN WHERE bs.SUBJECT_ID IN (";

for(int i = 0; i < args.length; i++) {
  if(i == args.length - 1) {
    query += "?)";
  } else {
    query += "?, ";
  }
}

query += " GROUP BY b.ISBN, b.TITLE ORDER BY COUNT(*) DESC";
PreparedStatement ps = conn.prepareStatement(query);

for(int i = 0; i < args.length; i++) {
  int psVar = i + 1; 
  ps.setInt(psVar, Integer.parseInt(args[i]));
}

ResultSet rset = ps.executeQuery();