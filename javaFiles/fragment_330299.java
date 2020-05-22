Map<String, Document> docs = form.getDocuments();
Map<String, Object> requestargs = docs;  // not actually allowed
requestargs.put("Foo", new Object());
for (Document doc : docs.values()) {
  // doc isn't necessarily a Document! ClassCastExceptions abound.
}