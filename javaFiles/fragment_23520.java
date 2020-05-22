PreparedStatement statement = getSession().prepare(
                               "INSERT INTO pixelstore.image " +
                               "(image_name, " +
                               " upload_time, " + 
                               " upload_by, " + 
                               " file_type, " + 
                               " file_size" +
                               ") VALUES (?, ?, ?, ?, ?);"); 

// create the bound statement and initialise it with your prepared statement
BoundStatement boundStatement = new BoundStatement(statement);

session.execute( // this is where the query is executed
  boundStatement.bind( // here you are binding the 'boundStatement'
    "background", TimeUtil.getTimeUUID(),  "lyubent", "png", "130527"));