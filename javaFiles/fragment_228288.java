Timeout timeout = new Timeout(Duration.create(5, "seconds"));    

private Route createRoutes() {
    return pathPrefix("typeOne", () ->
                path(PathMatchers.segment(), id ->
                    get(() -> 
                            onSuccess(() -> Patterns.ask(actor, id, timeout),
                                      extraction -> if (extraction instanceof WhatEverYouExpect) complete(extraction)
                                     )
                        )
    ));
}