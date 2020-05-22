object Main extends App {
   val services = new Services
   // ...
   val actor1 = system.actorOf(Props(classOf[MyActor], services), "actor1")
   val actor2 = system.actorOf(Props(classOf[MyActor], services), "actor2")
}

class Services {
   val cassandraSession = ??? // ... however you create it
}