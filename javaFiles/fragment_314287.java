@RestController
public class EntityController {

    private ExecutorService executor;

    @GetMapping
    public DeferredResult<Entity> getEntity(/**params**/) {
        DeferredResult<Entity> result = new DeferredResult<>();
        // request thread freed and returned to the request handling thread pool
        executor.execute(() -> output.setResult(entity)
        return result;
    }

}