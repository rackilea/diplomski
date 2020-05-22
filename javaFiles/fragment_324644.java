AcroFields fields = myReader.getAcroFields();

Set<String> fieldNames = fields.getFields().keySet();
for (String fldName : fieldNames) {
  System.out.println( fldName + ": " + fields.getField( fldName ) );
}