public List<ItemBean> getItemFromdb(LoginBean user) throws SQLException {

    //  whatever you are doing comes here
    while (rs.next()) {
        ItemBean item = new ItemBean();
        item.setId(rs.getInt("id");  //  you need to have this, here id is the the primary key of the table
        item.setItemName(rs.getString("itemname"));
        item.setItemPrice(rs.getDouble("itemprice"));
        item.setTransactionTime(rs.getString("transactiontime"));
     // item.setUserid(rs.getInt("userid"));
        item.setEmail(rs.getString("email"));
        itemList.add(item); 
    }

    //  rest of the code
}