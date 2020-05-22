public HandlerFunction<ServerResponse> postSearch = request ->
    {
        return request.formData()
                .map(value ->
                {
                    SearchQuery sq = new SearchQuery();
                    sq.setOrigin(value.getFirst("origin"));
                    sq.setDestination(value.getFirst("destination"));
                    sq.setFlightDate(value.getFirst("flightDate"));
                    return sq;
                })
                .flatMap(sq ->
                {
                    Flux<Flight>      flights = this.searchClient.post()
                            .uri("/search/get/")
                            .body(BodyInserters.fromObject(sq))
                            .retrieve()
                            .bodyToFlux(Flight.class);
                    Map<String, Flux<Flight>> model = new HashMap<>();
                    model.put("flights",
                              flights);
                    return ServerResponse.ok()
                            .render("result",
                                    model);
                });

    };