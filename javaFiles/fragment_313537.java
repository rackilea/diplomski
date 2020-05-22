public class HomeController extends Controller {
    @Inject HttpExecutionContext ec;

    public Result index() {
        // The data to parallel processing
        List<String> list = List.of("Item 1", "Item 2", "Item 3","Item 4", "Item 5", "Item 6", "Item 7", "Item 8");
        Stream<String> listInParralel = list.parallelStream(); 

        // Take all that you need from the HttpExecutionContext.  
        String uri = request().uri();

        System.out.println("START");
        listInParralel.forEach(item -> {
            // use pre cached HTTP context data, liek `uri`
            System.out.println("item: " + item + " in "  +  uri  + "(" + Thread.currentThread().getName() + ")");
        });

        // Results
        /*
        START
        item: Item 1 in /(ForkJoinPool.commonPool-worker-7)
        item: Item 8 in /(ForkJoinPool.commonPool-worker-3)
        item: Item 7 in /(ForkJoinPool.commonPool-worker-15)
        item: Item 4 in /(ForkJoinPool.commonPool-worker-9)
        item: Item 3 in /(ForkJoinPool.commonPool-worker-13)
        item: Item 2 in /(ForkJoinPool.commonPool-worker-5)
        item: Item 5 in /(ForkJoinPool.commonPool-worker-11)
        item: Item 6 in /(application-akka.actor.default-dispatcher-4)
        */

        return ok("Done");
    }

}