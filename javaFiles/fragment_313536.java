public class HomeController extends Controller {
    @Inject HttpExecutionContext ec;

    public Result index() {
        // The data to parallel processing
        List<String> list = List.of("Item 1", "Item 2", "Item 3","Item 4", "Item 5", "Item 6", "Item 7", "Item 8");

        // Make a Stream. The `parallelStream` is not used because 
        // `current.execute` will make it run in parallel.
        Stream<String> listInParralel = list.stream(); 

        // The current executor with the HTTP context. 
        Executor current = ec.current();

        System.out.println("START");
        listInParralel.forEach(item -> {
          current.execute(()-> {
            // request().uri() internally uses HttpExecutionContext
            System.out.println("item: " + item + " in "  +  request().uri()  + "(" + Thread.currentThread().getName() + ")");
          });
        });

        // Results
        /*
        START
        item: Item 7 in /(application-akka.actor.default-dispatcher-9)
        item: Item 5 in /(application-akka.actor.default-dispatcher-7)
        item: Item 3 in /(application-akka.actor.default-dispatcher-5)
        item: Item 1 in /(application-akka.actor.default-dispatcher-6)
        item: Item 6 in /(application-akka.actor.default-dispatcher-8)
        item: Item 4 in /(application-akka.actor.default-dispatcher-2)
        item: Item 2 in /(application-akka.actor.default-dispatcher-4)
        item: Item 8 in /(application-akka.actor.default-dispatcher-9)
        */

        return ok("Done");
    }

}