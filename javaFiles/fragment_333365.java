//First convert properties to Map<String, String>
Map<String, String> m = Maps.fromProperties(properties);

//Sort them so that password < url < user for each datasource and dataSource1.* < dataSource2.*. In your case default string ordering is ok so we can take a normal treemap
Map<String, String> sorted = Maps.newTreeMap();
sorted.putAll(m);

//Create Multimap<String, List<String>> mapping datasourcename->[password,url, user ]

    Function<Map.Entry<String, String>, String> propToList = new Function<String, Integer>() {
        @Override
        public String apply(Map.Entry<String, String> entry) {
            return entry.getKey().split("\\.")[0];
        }
    };

Multimap<Integer, String> nameToParamMap = Multimaps.index(m.entrySet(), propToList);

//Convert it to map
Map<String, Collection<String>> mm = nameToParamMap.asMap();

//Transform it to Map<String, Datasource>
Map<String, Datasource> mSD = Maps.transformEntries(mm, new EntryTransformer<String, Collection<String>, DataSource>() {
         public DataSource transformEntry(String key, Collection<String> value) {
            // Create your datasource. You know by now that Collection<String> is actually a list so you can assume elements are in order: [password, url, user]
            return new Datasource(.....)
         }
       };

//Copy transformed map so it's no longer a view
Map<String, Datasource> finalMap = Maps.newHashMap(mSD);