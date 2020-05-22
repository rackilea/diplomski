new String[] { "your_primary_key_column_name" });

prepareStatement.executeUpdate();

ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
if (null != generatedKeys && generatedKeys.next()) {
     Long primaryKey = generatedKeys.getLong(1);
}