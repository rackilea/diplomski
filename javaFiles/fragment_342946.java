CallableStatement statement = con.prepareCall(query); 
ByteArrayInputStream baisForIndex2 = new ByteArrayInputStream(immAsBytes);
ByteArrayInputStream baisForIndex3 = new ByteArrayInputStream(immAsBytes);
statement.setDate(1, sqlDate);
statement.setBinaryStream(2, baisForIndex2, immAsBytes.length);
statement.setBinaryStream(3, baisForIndex3, immAsBytes.length);
statement.executeUpdate();