YourClass instance = getItSomehow();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(instance);
oos.close();
ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

Connection connection = null;
PreparedStatement preparedStatement = null;

try {
    connection = database.getConnection();
    preparedStatement = connection.prepareStatement(SOME_SQL);
    preparedStatement.setBinaryStream(bais);
    // ...