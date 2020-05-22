val firstSingle: Single<Optional<RequestOne>> = requestOne.onErrorReturnItem(Optional.empty())
val secondSingle: Single<Optional<Request = requestTwo.onErrorReturnItem(Optional.empty())

Single.zip(fistSingle, secondSingle, BiFunction { r1: Optional<RequestOne>, r2: Optional<List<RequestTwo>> ->
  return@BiFunction CombinedResult(r1.value, r2.value)
})