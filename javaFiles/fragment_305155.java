play {
  akka {
    actor {
      game-logic-context = {
        fork-join-executor {
          parallelism-min = 300
          parallelism-max = 300 // thread pool with 300 threads
        }
      }
    }
  }
}