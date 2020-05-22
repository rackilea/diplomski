Set<String> getFields = Set.of({SearchField.FILE_ABSOLUTE_PATH.getName()});
for(int i = 0; i < result.length; i++)
{
    final Document document = reader.document(hits[i].doc, getFields);
    ...
}