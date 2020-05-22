public class PostProcessing implements Runnable{

private String x;
private String y;

public PostProcessing(String x, String y) {
    this.x = x;
    this.y = y;
}

@Override
public void run() {

    x.doSomething();
    y.doSomethingelse();

    /*LONG RUNNING OPERATIONS GO HERE*/
}

}