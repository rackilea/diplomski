private DocParserFactory docParserFactory;

// You can inject either the real instance (DocParserFactoryImpl) or a 
// test instance which returns dummy parsers with predicable results 
// when you construct this object. 
public ThisObject(DocParserFactory docParserFactory) {
    this.docParserFactory = docParserFactory;
}

...

// Your code
public void someMethod() {

    ...

    FirestoreRecyclerOptions<Model1> fro1 = new 
    FirestoreRecyclerOptions.Builder<Model1>()
        .setQuery(query1, docParserFactory.getModel1Parser())
        .build();
    FirestoreRecyclerOptions<Model2> fro2 = new 
    FirestoreRecyclerOptions.Builder<Model2>()
        .setQuery(query2, docParserFactory.getModel2Parser())
        .build();

    ...

}