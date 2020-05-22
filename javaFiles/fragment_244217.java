CompletableFuture<HandelerFuture[]> future = dispatchBoth(com);
    HandelerFuture[] results = future.get();
    JsonArray finalArray;
    for (HandelerFuture result:results) {
        try {
            // extract partial json array
            JsonArray partialArray = result.get();
            // combine partialArray with finalArray somehow
        } catch (Exception e) {
            // this is the exception got in handle() method as ar.cause().
            e.printStackTrace();
        }
    }
    routingContext.response().end(finalArray.encodePrettily());