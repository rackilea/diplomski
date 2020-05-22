ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("CHAR_ARRAY", conn);
String[] Parameter = { "user1", "Administrator" };
java.sql.Array sqlArray = new oracle.sql.ARRAY(arrayDescriptor, conn, content);
.
.
pstmt.setArray(1, sqlArray);