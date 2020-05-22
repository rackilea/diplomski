(...)
akka.actor.deployment {
  /sparqlQuerierMasterActor/sparqlQuerierPool {
    router = round-robin-pool
    nr-of-instances = 12
    target.nodes = [
       "akka.tcp://SYSTEM@XXX.XXX.XXX.XXX:2560"
      ,"akka.tcp://SYSTEM@YYY.YYY.YYY.YYY:2560"
      ,"akka.tcp://SYSTEM@ZZZ.ZZZ.ZZZ.ZZZ:2560"

    ]
  }
}
(...)