public ArrayList<Items> getItems(Connection connection, int orderId) throws Exception
{
    ArrayList<Items> itemsList = new ArrayList<Items>();
    try
    {
        String query = "SELECT Id, name, Price from Items where id in "
                + "(select ItemId from Orders where id = ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            int itemId = rs.getInt(1);
            String itemName = rs.getString(2);
            double itemPrice = rs.getDouble(3);
            Items item = new Items(itemId, itemName, itemPrice);
            itemsList.add(item);
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return itemsList;
}