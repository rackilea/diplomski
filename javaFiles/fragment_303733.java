@Service
public class YourClass {
    public void methodA() {
        methodB();
    }

    @Async
    public void methodB() {
        // Your POST logic
    }
}