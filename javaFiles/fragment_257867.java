public class Application extends Controller {
@Inject HttpExecutionContext ec;

public CompletionStage<Result> index() {
    someCompletableFuture.supplyAsync(() -> { 
      // do something with request()
    }, ec.current());
  }
}