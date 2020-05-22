public String getJson() throws NotesException {
    ...
    View view1 = ...;
    JSONObject jsonMain = new JSONObject();
    jsonMain.put("identifier", "name");
    jsonMain.put("label", "name");
    Document doc = view1.getFirstDocument();
    JSONArray items = new JSONArray();
    while (doc != null) {
        items.add(getJsonDocAndChildren(doc));
        Document docTemp = view1.getNextSibling(doc);
        doc.recycle();
        doc = docTemp;
    }
    jsonMain.put("items", items);
    return jsonMain.toJSONString();
}

private JSONObject getJsonDocAndChildren(Document doc) throws NotesException {
    JSONObject jsonDoc = new JSONObject();
    jsonDoc.put("name", doc.getItemValueString("Name"));
    jsonDoc.put("field", doc.getItemValueString("FieldValue"));
    DocumentCollection responses = doc.getResponses();
    if (responses.getCount() > 0) {
        Document docResponse = responses.getFirstDocument();
        JSONArray children = new JSONArray();
        while (docResponse != null) {
            children.add(getJsonDocAndChildren(docResponse));
            Document docTemp = responses.getNextDocument(docResponse);
            docResponse.recycle();
            docResponse = docTemp;
        }
        jsonDoc.put("children", children);
    }
    return jsonDoc;
}