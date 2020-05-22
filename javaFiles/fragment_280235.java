public static void main(String[] args) throws Exception {

  final Config config = ConfigFactory.parseString(
    "akka.actor.provider=cluster\n" +
    "akka.remote.netty.tcp.port=2551\n" +
    "akka.cluster.seed-nodes = [ \"akka.tcp://ClusterSystem@127.0.0.1:2551\"]\n");

  ActorSystem node1 = ActorSystem.create("ClusterSystem", config);
  ActorSystem node2 = ActorSystem.create("ClusterSystem",
    ConfigFactory.parseString("akka.remote.netty.tcp.port=2552")
      .withFallback(config));

  // wait a bit for the cluster to form
  Thread.sleep(3000);

  ActorRef subscriber = node1.actorOf(
    Props.create(Subscriber.class),
    "subscriber");

  ActorRef publisher = node2.actorOf(
    Props.create(Publisher.class), 
    "publisher");

  // wait a bit for the subscription to be gossiped
  Thread.sleep(3000);

  publisher.tell("testMessage1", ActorRef.noSender());
}