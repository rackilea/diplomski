val solvers: List[Future => Int] = ... //some list of functions(tasks), Future is used to check if task was interrupted
  val (futures, cancels): solvers.map(cancellableFuture) //see https://stackoverflow.com/questions/16020964/cancellation-with-future-and-promise-in-scala

  (Future firstCompletedOf futures) onComplete { result: Int =>
        cancels.foreach(_())
        use(result)
  }