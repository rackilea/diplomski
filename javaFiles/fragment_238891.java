public class MyTest {

@Test
public void myTest() {
    ExecutorService es = Executors.newFixedThreadPool(5);
    es.submit(new Handler(1));
    es.submit(new Handler(2));
    es.submit(new Handler(3));
    // block to show theads executions
    try {
        System.in.read();
    } catch (IOException e) {           
        e.printStackTrace();
    } 
}

}

class Handler implements Runnable {
int userId;
public Handler(int userId) {
    super();
    this.userId = userId;
}
@Override
public void run() {
    System.out.println("running for user:"+userId);

}

}