apiResultStream
  .flatMap(result -> {
    if (result.response == true) {
      return callSuccessApi(result)
    }
    else {
      return callFailureApi(result)
  })
  //Do any more calls you need
  .subscribe(...