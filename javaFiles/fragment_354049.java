rs = stmt.executeQuery("SELECT sales.InvoiceNumber, sales.ShipToAddress, sales.Date "
            + "FROM sales, customers "
            + "WHERE sales.CardRecordID = customers.CardRecordID "
            + "AND customers.Name = 'Cash Sales' "
            + "AND sales.Date BETWEEN '" + sdate + "' AND '" + edate + "' "
            + "ORDER BY sales.ShipToAddress ASC, sales.Date DESC"
            + ";");