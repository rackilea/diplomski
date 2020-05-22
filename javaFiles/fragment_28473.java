public class Test {

static long counter=0;
public static void main(String[] args) {
    long t1  = System.nanoTime();
    Test test = new Test();
    for (int i=0;i<1000000000;i++) {
        test.doStuff();//or dostuff2
    }
    long t2  = System.nanoTime();
    System.err.println((t2-t1)/1000000);
    System.err.println(counter); // to check it wasnt optimised away
}

private void doStuff() {
    List l = new ArrayList();
    if (l!=null) {
        counter++;
    }
}

List l2 = new ArrayList();
private void doStuff2() {
    if (l2!=null) {
        counter++;
    }
}
}