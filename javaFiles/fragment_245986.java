@Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
        throws Exception {
        System.out.println("-----postProcessSearchQuery called------");

        addSearchTerm(searchQuery, searchContext, "sampleCollectionName", true);
        addSearchTerm(searchQuery, searchContext, "biobankName", true);
        addSearchTerm(searchQuery, searchContext, "materialType", true);
        addSearchTerm(searchQuery, searchContext, "container", true);
        addSearchTerm(searchQuery, searchContext, "storageTemperature", true);
        .....
        .....

        LinkedHashMap<String, Object> params =
            (LinkedHashMap<String, Object>)searchContext.getAttribute("params");

        if (params != null) {
            String expandoAttributes = (String)params.get("expandoAttributes");

            if (Validator.isNotNull(expandoAttributes)) {
                addSearchExpando(searchQuery, searchContext, expandoAttributes);
            }
        }
    }