PreparedStatement ps = con.preparedStatement("your query");

for(int i = 0; i < arrayColId.length; i++) {
     ps.setString(1, qId);
     ps.setString(2, arrayColId[i]);
     ps.addBatch();    
}

ps.executeBatch();