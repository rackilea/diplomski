public class MyTest() {
  private ActorSystem system = ActorSystem.create("worker");;
  private Props props = Props.create(Worker.class , system.guardian().toString());
  private ActorRef actor = system.actorOf(props);

  @Test
  public void testMain() throws Exception {
    Future sFuture = ask(actor, "ping" , 1000);
    System.out.println("First : " + sFuture);
  }
}