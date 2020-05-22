HashMap<String, Class<? extends Document>> builders = new HashMap<String, Class<? extends Document>>();
builders.put("xml", XMLDocument.class);

try {
  Document document = builders.get("xml").newInstance();
}
catch (...)