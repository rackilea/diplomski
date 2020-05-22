package stack.overflow.example;

public interface IExampleService {
void callExpensiveService();
}

public class TestService implements IExampleService {

@Override
public void callExpensiveService() {
    // This is a mock service, we run this as many 
    // times as we like for free to test our software

}
}

public class ExpensiveService implements IExampleService {
@Override
public void callExpensiveService() {
    // This performs some really expensive service,
    // Ideally this will only happen in the field
    // We'd rather test as much of our software for
    // free if possible.
}
}


public class Main {

/**
 * @param args
 */
public static void main(String[] args) {

    // In a test program I might write
    IExampleService testService = new TestService();
    testService.callExpensiveService();

    // Alternatively, in a real program I might write
    IExampleService testService = new ExpensiveService();
    testService.callExpensiveService();

    // The difference above, is that we can vary the concrete 
    // class which is instantiated. In reality we can use a 
    // service locator, or use dependency injection to determine 
    // at runtime which class to implement.

    // So in the above example my testing can be done for free, but 
    // real world users would still be charged. Point is that the interface
    // provides a contract that we know will always be fulfilled, regardless 
    // of the implementation. 

}

}