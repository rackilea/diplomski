String sql = "INSERT INTO testtable(stringcolumn, blobcolumn) VALUES(?,?)";
PreparedStatement statement = conn.getConnection().prepareStatement(sql);
statement.setLong(1, version);
ByteArrayInputStream bais = new ByteArrayInputStream(getByteArrayFromFile(document));
statement.setBlob(2, bais);          
statement.execute();
conn.commit();