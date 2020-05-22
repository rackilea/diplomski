akka {
  log-dead-letters-during-shutdown = off
  actor {
    provider = "akka.remote.RemoteActorRefProvider"
    deployment {
      /Messages {
        remote = "akka.tcp://Server@127.0.0.1:2553"
      }
    }
  } 
}