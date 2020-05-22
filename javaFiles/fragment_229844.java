String sql = "SELECT `ItemName` FROM `invoicelist` WHERE `InvoiceId` = '" + invoicenum + "' ";
try { 
    ResultSet rs =   CODE.DbAccess.getdata(sql);

    while (rs.next()) {
        description += rs.getString("ItemName") + ",";
    } 

    description = description.substring(0, description.length() - 1);

    //System.out.println(description);  
}