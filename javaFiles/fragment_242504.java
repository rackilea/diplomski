// Query
public void insertToDb(String name_entry, String tmark_entry, String item_entry, int quantity_entry, int price_entry){
    name_db = name_entry;
    tm_db = tmark_entry;
    item_db = item_entry;
    quantity_db = quantity_entry;
    price_db = price_entry;
try{
    connectDb();
    String query =
        "INSERT INTO ledger_table (Name, Trade Mark, Item, Quantity, Price) VALUES (?, ?, ?, ?, ?)";        
    PreparedStatement statement = c.prepareStatement(query);
    statement.setString(1, name_db);
    statement.setString(2, tm_db);
    statement.setString(3, item_db);
    statement.setInt(4, quantity_db);
    statement.setInt(5, price_db);
    statement.executeUpdate();            
    c.commit();
    c.close();           

}
catch(Exception e){            
}             
}