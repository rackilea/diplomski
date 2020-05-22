private CompletableFuture<Void> processSomething(final SomeEvent event) {
    final CompletableFuture<PaginatedQueryList<Detail>> detail = dao.getData(event.getOrderId());
    return (CompletableFuture<Void>)detail.thenApply(n -> n.stream()
        .filter(i -> i.getBusinessType().equals(BusinessType.AWESOME))
        .findFirst()
        .filter(i -> i.getLastUpdateEventTimestamp() <= event.getCreationTime())) // This returns Optional<Detail>
        .thenAccept(i -> deleteItem(event, i).join())); // deleteItem is a async call that returns CompletableFuture<Void>
}

private CompletableFuture<Void> deleteItem(Optional<Detail> optionalDetail){
     if(optionalDetail.isPresent()){
       // Your existing logic
     }
}