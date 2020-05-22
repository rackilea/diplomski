Observable.range(Integer.MAX_VALUE)
    // Get each page in order.
    .concatMap(page -> getResults(page))
    // Take every result up to and including the one where the next page index is null.
    .takeUntil(result -> result.next == null)
    // Add each output to a list builder. I'm using Guava's ImmutableList, but you could
    // just as easily use a regular ArrayList and avoid having to map afterwards. I just
    // personally prefer outputting an immutable data structure, and using the builder
    // is natural for this.
    //
    // Also, if you wanted to have the observable stream the full output at each page,
    // you could use collect instead of reduce. Note it has a slightly different syntax. 
    .reduce(
        ImmutableList.<ResponseObject>builder(),
        (builder, response) -> builder.addAll(response.results))
    // Convert list builder to one List<ResponseObject> of all the things.
    .map(builder -> builder.build())
    .subscribe(results -> { /* Do something with results. */ });