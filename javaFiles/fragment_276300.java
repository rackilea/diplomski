// create the filter
// to cache the results, add .cache(true);
BoolFilterBuilder filterBuilder = FilterBuilders.boolFilter();

// did you mean to skip the first one?
for (int i = 0; i < codes_vec.length; ++i)
    filterBuilder.must(FilterBuilders.termFilter("code", codes_vec[i]));

// add the filter to your search
SearchResponse response = client.prepareSearch("index1")
            .setFilter(filterBuilder)
            .setFrom(0).setSize(10)
            .execute()
            .actionGet();