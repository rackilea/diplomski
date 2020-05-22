public class BlobType implements UserType {

  public int[] sqlTypes() {
      return new int[] { Types.BLOB };
  }

  public Class returnedClass() {
      return Blob.class;
  }

  public Object nullSafeGet(ResultSet aResultSet, String[] aColName, Object aObject)
          throws HibernateException, SQLException {
      return getBlobFromBinaryStream(aResultSet, aColName[0]);
  }

  private byte[] getBlobFromBinaryStream(ResultSet aResultSet, String aColName)
          throws SQLException {

      byte[] theBuff = new byte[2 * 1024];
      InputStream theInStream = aResultSet.getBinaryStream(aColName);

      ByteArrayOutputStream theBaos = new ByteArrayOutputStream();
      int n = 0;
      try {
          if (theInStream != null)
          {
              while (-1 != (n = theInStream.read(theBuff))) {
                  theBaos.write(theBuff, 0, n);
              }
          }
          theBaos.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }

      return theBaos.toByteArray();
  }

  public void nullSafeSet(PreparedStatement aStmt, Object aValue, int aIndex)
          throws HibernateException, SQLException {
      aStmt.setBytes(aIndex, (byte[]) aValue);
  }

  public boolean equals(Object x, Object y) {
      if ((x == y) ||
              (x != null && y != null && Arrays.equals(
                      ((byte[]) x),
                      ((byte[]) y)))) {
          return true;
      }
      return false;
  }

  public int hashCode(Object aArg) throws HibernateException {
      return aArg.hashCode();
  }

  public boolean isMutable() {
      return false;
  }

  public Object assemble(Serializable aSerializableObject, Object aObject) throws HibernateException {
      return null;
  }

  public Serializable disassemble(Object aObject) throws HibernateException {
      return null;
  }

  public Object replace(Object aObject1, Object aObject2, Object aObject3) throws HibernateException {
      return null;
  }

  public Object deepCopy(Object aValue) {
      return aValue;
  }

}