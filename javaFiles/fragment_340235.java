return service1().flatMap(response1 ->
        Flux.merge(service23Agg(response1.a1), service4Agg(response1.a2))
                .reduce((aggResponse, aggResponse2) -> new AggResponse(
                        response1.a1,
                        response1.a2,
                        Optional.ofNullable(aggResponse.d1)
                                .orElse(aggResponse2.d1),
                        Optional.ofNullable(aggResponse.response2s)
                                .orElse(aggResponse2.response2s))));