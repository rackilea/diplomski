Mono<Feed> unifiedFeedMono = request
        .bodyToMono(AddFeedRequestDto.class)  // Mono<AddFeedRequestDto>
        .map(AddFeedRequestDto::getFeeds)     // Mono<List<String>> feedUrls
        .flatMapMany(Flux::fromIterable)      // Flux<String> feedUrls
        .flatMap(this::getFeedResponse)       // Flux<Feed>
        .map(Feed::getItems)                  // Flux<List<Item>>
        .flatMap(Flux::fromIterable)          // Flux<Item>
        .collectList()                        // Mono<List<Item>>
        .map(Feed::new);                      // Mono<Feed>