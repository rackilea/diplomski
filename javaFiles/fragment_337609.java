// Use the SearchOption enum from above
Map<SearchOption, String> searches = new HashMap<SearchOption, String>();

public List<SearchResult> search(List<SearchOption> options) {
    List<SearchResult> results = new LinkedList<SearchResult>();
    for(SearchOption option : options) {
        String query = searches.get(option);
        SearchResult result = MySearchService.executeQuery(query);
        results.add(result);
    }
    return results;

}