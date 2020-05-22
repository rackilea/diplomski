EventBus bus;

bus.receive($("job.sink"), (Event<String> ev) -> {
  return ev.getData().toUpperCase();
}); 

bus.sendAndReceive(
    "job.sink",
   Event.wrap("Hello World!"),
   s -> System.out.printf("Got %s on thread %s%n", s, Thread.currentThread())
);