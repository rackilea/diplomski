@Component
public class MyComponent {
    @Async
    Future<String> doSomething(String s, int i, long l, Object o) {
        // this will be executed asynchronously
        return new AsyncResult<>("result");
    }
}