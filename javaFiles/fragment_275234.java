for (Product product : objectList) {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/icepos", "root", "");
            pst = con.prepareStatement("insert into sale_product(item,price,qty,total)values(?,?,?,?) ");
            pst.setString(1, product.getItem());
            pst.setInt(2, product.getPrice());
            pst.setInt(3, product.getQty());
            pst.setInt(4, product.getTotal());
            pst.executeUpdate();

            out.println("<font color='green'>  Record Adddd   </font>");
        } catch (SQLException ex) {
            out.println("<font color='red'>  Record Failed   </font>");
        }
    }