PreparedStatement statement = connection.prepareStatement("INSERT INTO item(stream_id,"+
                                          "stream_item_date, channel) "+
                                          "VALUES (?, ?, ?);");
for(Item item : stream.getItems()){
    statement.setLong(1, item.getStream_id());
    statement.setString(2, item.getStream_item_date());
    statement.setString(3, item.getChannel());
    statement.addBatch();
}