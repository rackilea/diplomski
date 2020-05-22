// this will contain the collection of documents, one for each line in `locus.csv`
List<Document> locusDocuments = new ArrayList<>();

FileLocus fl = new FileLocus("/Users/valentinafratini/Documents/Progetto Tesi/FactoryMethodDb/locus.csv");
fl.readFile();
while (fl.line!=null) {
    fl.line = fl.reader.readLine();

    if (fl.line!=null && fl.line.length()>0) {
        fl.obj = fl.line.split("\\s+");
        fl.readSingleObj();

        // create and populate a sub document for the current line
        Document locusDocument = new Document();
        locusDocument.append("mrna_acc", fl.mrna_acc);
        locusDocument.append("gene", fl.gene);
        locusDocument.append("class", fl.classe);

        // assign the current sub document to the collection of locus documents
        locusDocuments.add(locusDocument);
    }
}

// add the collection of locus documents to the outer document
d.append("locus", locusDocuments);