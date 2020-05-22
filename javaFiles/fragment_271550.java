Iterator i = active.iterator();
while (i.hasNext()) {
  Document doc = (Document) i.next();
  if (doc.getIdNum() == docId) {
    archive.add(doc);
    i.remove();
    System.out.printf(Messages.enteredIntoArchive(), doc.getIdNum());
  }
  else
    System.out.println(Messages.notFound());
}