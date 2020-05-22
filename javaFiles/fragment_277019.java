class Document {
  public boolean equals(Document d)
  {
    //do something
  }
}

Document doc1 = new Document();
Document doc2 = new Document();
String string = new String();

doc1.equals(doc2); // calls Document.equals
doc1.equals(string); // calls Object.equals!