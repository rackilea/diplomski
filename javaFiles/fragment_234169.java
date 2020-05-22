public class SinTest {
  public static void main(String args[]) {
    long angle = Long.parseLong(args[0]);
    long startTime = System.nanoTime();
    for(long l=0L; l<=1000000L; l++) {
      Math.sin(angle);
    }
    long estimatedTime = System.nanoTime() - startTime;
    System.out.println(estimatedTime);
  }
}

$ java SinTest 100000
29181000
$ java SinTest 10000000
138598000