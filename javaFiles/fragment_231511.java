PreparedStatement customerInsert = DBconnection.getConnection().prepareStatement(
    "INSERT INTO customer (customerName, addressId, active, createDate, createdBy, lastUpdate, lastUpdateBy)" +
                   "VALUES(?, ?, ?, ?, ?, ?, ?);"
);
customerInsert.setString(1, name);
customerInsert.setInt(2, addressId);
// ...etc. Notice that the parameter indexes start with 1 rather than 0 as you might expect