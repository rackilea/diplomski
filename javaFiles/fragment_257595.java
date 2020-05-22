akka.actor.deployment {
  /allUsers {
    router = broadcast-group
    routees.paths = ["/user/service/*"]
    cluster {
      enabled = on
      allow-local-routees = on
    }
  }
}