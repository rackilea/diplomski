package com.myCompany;

// ... imports ...

public class MyAppSearchMappingFactory {
    @Factory
    public SearchMapping getSearchMapping() {
        SearchMapping mapping = new SearchMapping();
        for ( Map.Entry<Class<?>, String> entry : getIndexNames() ) {
             mapping.entity( entry.getKey() ).indexed().indexName( entry.getValue() );
        }
        return mapping;
    }

    private Map<Class<?>, String> getIndexNames() {
         // Fetch the index names somehow. Maybe just use a different implementation of this class in each application?
    }
}