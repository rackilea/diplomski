public class MyAppSearchMappingFactory {
    @Factory
    public SearchMapping getSearchMapping() {
        SearchMapping mapping = new SearchMapping();
        mapping
            .analyzerDef( "en", StandardTokenizerFactory.class )
                .filter( LowerCaseFilterFactory.class )
                .filter( EnglishPorterFilterFactory.class )
            .entity(Address.class).indexed()
                .property("addressId", ElementType.METHOD)
                    .documentId()
                        .name("id")
                .property("street1", ElementType.METHOD)
                    .field()
                        .analyzer("en")
                        .store(Store.YES)
                    .field()
                        .name("address_data")
                        .analyzer("en");
        return mapping;
    }
}