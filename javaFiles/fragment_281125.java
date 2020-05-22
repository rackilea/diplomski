@Component
public class MyComponent {
    @Async
    void doSomething(String s, int i, long l, Object o) {
        // this will be executed asynchronously
    }
}