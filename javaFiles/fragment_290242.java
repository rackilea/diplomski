public static String[] getFieldNames(IndexReader reader) {
    List<String> fieldNames = new ArrayList<String>();
    //For a simple reader over only one index, reader.leaves() should only  return one LeafReaderContext
    for (LeafReaderContext readerCtx : reader.leaves()) {
        FieldInfos fields = readerCtx.reader().getFieldInfos();
        for (FieldInfo field : fields) {
            //Check whether the field is indexed and searchable, perhaps?
            fieldNames.add(field.name);
        }
    }
    return fieldNames.toArray(new String[fieldNames.size()]); 
}