//exception is CREATED immediately, but USED lazily
return Mono.error(new IllegalStateException())
    //mono is CREATED immediately. The data it will emit is also CREATED immediately. But it all triggers LAZILY.
    .then(Mono.just(new SomeResponse()))
    //note that then* operators completely ignore previous step's result (unless it is an error)
    .thenReturn(new SuccessResponse("Awesome")));