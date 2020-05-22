public Future<Integer> getOwnerIdFromClient(){
    Future<Integer> result=new CompletableFuture<Integer>();

    client
    .query(getOwnerDbIdQuery)
    .enqueue(
    new ApolloCall.Callback<>(){
        @Override
        public void onResponse(@Nonnull Response<Optional<GetOwnerDbIdQuery.Data>>response){
                // get owner Id
                System.out.println("OwnerId = "+ownerId);
                result.complete(ownerId)
                }

        @Override
        public void onFailure(@Nonnull ApolloException e){
                logger.error("Could not retrieve response from GetOwnerDbIdQuery.",e);result.completeExceptionally(e);


                }
        });

    return result;