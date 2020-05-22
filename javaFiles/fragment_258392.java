// 2nd parameter is ignored, if the session is transacted
final Session session = 
  connection.createSession(true, -1);

// Read messages

session.commit();
messageConsumer.close();
session.close();
connection.close();