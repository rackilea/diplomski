private Document document = new Document();
private List<Document> results = null;

public Document getDocument() {
    return document;
}

public void setDocument(Document document) {
    this.document = document;
}

public List<Document> getResults() {
    return results;
}

public void setResults(List<Document> results) {
    this.results = results;
}

public void generateResults() {
    results = new ArrayList<Document>();

    // dummy data
    Document doc = new Document();
    doc.setMainNumber("9343");
    doc.setSecNumber("71254");
    doc.setFormType("OTHER FORMS");
    doc.setSubFormType("CALGB");
    results.add(doc);
    doc = new Document();
    doc.setMainNumber("1234");
    doc.setSecNumber("4321");
    doc.setFormType("SOMETHING");
    doc.setSubFormType("MAYO");
    results.add(doc);
}

public String search() {
    return "results.xhtml?faces-redirect=true&amp;includeViewParams=true";
}