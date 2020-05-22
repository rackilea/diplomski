Clob clob=resultSet.getClob(1);

Reader reader = clob.getCharacterStream();
ByteArrayOutputStream out = new ByteArrayOutputStream();
int c;
  while ((c = reader.read()) != -1) {
            out.write(c);
 }
 reader.close();
 out.close();
 return out.toString();