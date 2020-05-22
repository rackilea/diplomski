public void search(Predicate<String> predicate, Elements elements) {
    List<Element> filteredElements = 
        elements.stream()
                .filter(element -> predicate.test(element.ownText()))
                .collect(Collectors.toList());

    List<SearchResult> searchResults = 
        filteredElements.stream()
                        .map(element -> new SearchResult(element.ownText(),element.baseUri(),element.tagName()))
                        .collect(Collectors.toList());
}