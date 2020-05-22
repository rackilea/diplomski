public List<String> getSuggestion(String input) throws IOException {
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    SuggestionBuilder termSuggestionBuilder = SuggestBuilders.completionSuggestion("my_index_suggest").text(input);

    SuggestBuilder suggestBuilder = new SuggestBuilder();
    suggestBuilder.addSuggestion("suggest_field", termSuggestionBuilder);
    searchSourceBuilder.suggest(suggestBuilder);

    SearchRequest searchRequest = new SearchRequest();
    searchRequest.source(searchSourceBuilder);

    SearchResponse searchResponse = suggestionIndexClient.search(searchRequest, RequestOptions.DEFAULT);
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(searchResponse.getSuggest().iterator(), Spliterator.ORDERED), false)
            .flatMap(suggestion -> suggestion.getEntries().get(0).getOptions().stream())
            .map((Suggest.Suggestion.Entry.Option option) -> option.getText().toString())
            .collect(Collectors.toList());
}