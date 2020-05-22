public Flux<ItemDto> getAllItems() {
    webClient.get()
            .uri("/api/items?limit=1")//Used one to test
            .exchange()
            .expand(clientResponse -> {
                List<String> links = clientResponse.headers().asHttpHeaders().getValuesAsList("LINK");
                if(links.stream().anyMatch(link->link.contains("rel=\"next\""))){
                    for (String link : links){
                        if (link.contains("rel=\"next\"")){
                            return webClient.get()
                                    .uri("/api/items?limit=1&" + link.substring(link.indexOf("after="), link.indexOf("&")))
                                    .exchange();
                        }
                    }
                }
                return Flux.empty();
            })
            .flatMap(clientResponse ->
                    clientResponse.bodyToFlux(Map.class)
                            .map(ItemConverter::mapValueToItemDto));
}