private void getJsonDocAndChildren(Document doc, JsonWriter out) throws NotesException {
     out.name("name");
     out.value(doc.getItemValueString("Name"));
     out.name("field");
     out.value(doc.getItemValueString("field"));
     DocumentCollection responses = doc.getResponses();
     if (responses.getCount() > 0) {
          Document docResponse = responses.getFirstDocument();
          out.startArray();
          ...