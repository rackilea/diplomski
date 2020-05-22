@RestController
@RequestMapping("/demo")
public static class DemoRestController {

    private final TaskExecutor taskExecutor;

    public DemoRestController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @GetMapping
    public String get() {
        taskExecutor.execute(() -> {
            System.out.println("Hello from Task");
        });
        return "hello";
    }
}