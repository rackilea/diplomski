akka {
 actor {
  provider = "akka.cluster.ClusterActorRefProvider"

   serializers {
    java = "akka.serialization.JavaSerializer"
   }

  serialization-bindings {
   "java.io.Serializable" = "kyro"
  }
 }
}