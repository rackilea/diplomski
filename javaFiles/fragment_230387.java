CompletionStage<Path> getPath(int id) {
      service.getAData(id).thenCombine(service.getBdata(id)), (a, b) -> 
             return computePathLocally(a, b);
         ).thenCompose((result) -> 
           return result != null ?
                     CompletableFuture.completedFuture(result) :
                     service.computePath(id);
         )
}