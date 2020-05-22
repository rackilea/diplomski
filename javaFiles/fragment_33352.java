int fieldIndex = 0;
for(String fieldName : fieldsArray) {
   String value = r.getAttributeValue("",field);
   if(value != null && "body".equalsIgnoreCase(fieldName)) {
     pstmt.setCharacterStream(++fieldIndex, new StringReader(value), value.length());
   } else {
     pstmt.setString(++fieldIndex, value);
   }
}