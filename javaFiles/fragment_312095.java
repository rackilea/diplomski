FilterDef filterDef = new FilterDef();
        filterDef.setFilterName("springSecurityFilterChain");
        filterDef.setFilterClass("org.springframework.web.filter.DelegatingFilterProxy");
        container.addFilterDef(filterDef);

        FilterMap filterMapping = new FilterMap();
        filterMapping.setFilterName("springSecurityFilterChain");
        filterMapping.addURLPattern("/*");
        container.addFilterMap(filterMapping);