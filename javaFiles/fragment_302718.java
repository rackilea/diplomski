.doOnNext(response -> {
  if(!response.isSuccess())
    throw new FailureException(response.getMessage());
})
.subscribe(
    item  -> { /* handle success */ },
    error -> { /* handle failure */ }
);