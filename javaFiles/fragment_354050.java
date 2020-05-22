SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date startDate = formatter.parse(sdate);
java.util.Date endDate = formatter.parse(edate);
PreparedStatement pstmt = connection.prepareStatement("SELECT sales.InvoiceNumber, sales.ShipToAddress, sales.Date "
            + "FROM sales, customers "
            + "WHERE sales.CardRecordID = customers.CardRecordID "
            + "AND customers.Name = 'Cash Sales' "
            + "AND sales.Date BETWEEN ? AND ? "
            + "ORDER BY sales.ShipToAddress ASC, sales.Date DESC");
pstmt.setDate(1, new java.sql.Date(startDate.getTime()))
pstmt.setDate(2, new java.sql.Date(endDate.getTime()))