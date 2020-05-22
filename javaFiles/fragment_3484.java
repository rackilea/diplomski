MyRouter{
  akka {
    actor {
      deployment {
        /exampleRouter {
          router = consistent-hashing-group
        }
      }
    }
  }
}