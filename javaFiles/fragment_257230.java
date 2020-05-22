for (int i=0; i<nameList.size() && i<priceList.size() && i<timeList.size() && i<quantityList.size(); i++){

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, uname, pass);

        stmt = con.createStatement();
        String sql = "insert into currentorders (ordername, orderprice, ordertime, orderquantity, specInst, tableNo, wname) VALUES ('"+nameList.get(i)+"', '"+priceList.get(i)+"', '"+timeList.get(i)+"','"+quantityList.get(i)+"','"+specialInst+"','"+tableNo+"','"+waitername+"')";

        int count = stmt.executeUpdate(sql);
           if(count == 1){

    System.out.println("enteredd");
    //else return "not entered";
        }
        else {
    System.out.println("not enteredd");
        }


    }