String instId = req.getParameter("instId");
    String cartId = req.getParameter("cartId");
    String desc = req.getParameter("desc");
    String cost = req.getParameter("cost");
    BigDecimal amount = new BigDecimal(req.getParameter("amount"));
    String currency = req.getParameter("currency");
    String name = req.getParameter("name");
    String transId = req.getParameter("transId");
    String transStatus = req.getParameter("transStatus");
    String transTime = req.getParameter("transTime");
    String cardType = req.getParameter("cardType");
    Connection conn = null;
    Statement stmt = null;
    PrintWriter out = res.getWriter();
    try {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/orders", "root", "root");

        String sqlStr = "insert into orderdetails "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sqlStr)) {
            stmt.setString(1, transId);
            stmt.setString(2, instId);
            stmt.setString(3, cartId);
            stmt.setString(4, desc);
            stmt.setString(5, cost);
            stmt.setBigDecimal(6, amount);
            stmt.setString(7, currency);
            stmt.setString(8, name);
            stmt.setString(9, transStatus);
            stmt.setString(10, transTime);
            stmt.setString(11, cardType);
            int updateCount = stmt.executeUpdate();

            out.println("<html><head><title>Query Response</title></head><body>");
            out.println("<h3>Thank you for your query. " + updateCount + " record(s) updated.</h3>");
            out.println("<p>You query is: " + sqlStr + "</p>"); // Echo for debugging
            for (Enumeration<String> en = req.getParameterNames(); en.hasMoreElements();) {
                String paramName = en.nextElement();
                String paramValue = req.getParameter(paramName);
                out.println("<p>" + paramName + ": " + paramValue + "</p>"); // Echo for debugging
            }
        } // Does stmt.close()
    } catch (SQLException ex) {
        ex.printStackTrace();
    }