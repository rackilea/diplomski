@Service
class MyService {
  @Autowired
  private Executor executor;

  public CompletableFuture<?> compute() {
    return CompletableFuture.supplyAsync(() -> /* compute value */, executor);
  }
}