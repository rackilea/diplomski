while (rs.next()) {
    psInsert.setInt(1, rs.getInt(1));
    psInsert.setString(2, rs.getString(2));
    psInsert.setString(2,rs.getString(3));

    psInsert.addBatch();
    if(batchSize++ > 100){ //Execute every 100 rows
        psInsert.executeBatch();
        batchSize = 0;
    }
}

if(batchSize > 0){ //execute the remainings data
      psInsert.executeBatch();
}