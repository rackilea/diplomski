import java.util.Random;

public final class Example {

  /* note if the below read: static final int value = rand.nextInt(),
     this would be considered an illegal forward reference to rand */
  private static final int value = next();
  private static final Random rand = new Random();

  private static int next() {
    return rand.nextInt();
  }

  public static void main(final String[] argv) { }
}