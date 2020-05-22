PreparedStatement ps = null;
try {
    // serialize your map
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    ObjectOutputStream output = new ObjectOutputStream(b);
    o.writeObject(myObject().getHashes());

    ps = this.connection.prepareStatement("INSERT INTO myobjects (hashes) VALUES (?)");
    ps.setBinaryStream(1, new ByteArrayInputStream(b.toByteArray()));
    ps.executeUpdate();
} catch(IOException ioEx) {
    ioEx.printStackTrace();
} catch(SQLException sqlEx) {
    sqlEx.printStackTrace();
} finally {
    DAOUtility.close(this.connection, ps);
}