public class CopyableRandom extends Random implements Copyable<CopyableRandom>
{
  private final AtomicLong seed = new AtomicLong(0L);

  private final static long multiplier = 0x5DEECE66DL;
  private final static long addend = 0xBL;
  private final static long mask = (1L << 48) - 1;

  public CopyableRandom() { this(++seedUniquifier + System.nanoTime()); }
  private static volatile long seedUniquifier = 8682522807148012L;

  public CopyableRandom(long seed) { this.seed.set((seed ^ multiplier) & mask); }

  /* copy of superclasses code, as you can seed the seed changes */
  @Override
  protected int next(int bits)
  {
    long oldseed, nextseed;
    AtomicLong seed_ = this.seed;
    do
    {
      oldseed = seed_.get();
      nextseed = (oldseed * multiplier + addend) & mask;
    } while (!seed_.compareAndSet(oldseed, nextseed));
    return (int) (nextseed >>> (48 - bits));
  }

  /* necessary to prevent changes to seed that are made in constructor */
  @Override
  public CopyableRandom copy() { return new CopyableRandom((seed.get() ^ multiplier) & mask); }

  public static void main(String[] args)
  {
    CopyableRandom cr = new CopyableRandom();

    /* changes intern state of cr */
    for (int i = 0; i < 10; i++)
      System.out.println(cr.nextInt(50));

    Random copy = cr.copy()

    System.out.println("\nTEST: INTEGER\n");
    for (int i = 0; i < 10; i++)
      System.out.println("CR\t= " + cr.nextInt(50) + "\nCOPY\t= " + copy.nextInt(50) + "\n");

    Random anotherCopy = (copy instanceof CopyableRandom) ? ((CopyableRandom) copy).copy() : new Random();
    System.out.println("\nTEST: DOUBLE\n");
    for (int i = 0; i < 10; i++)
      System.out.println("CR\t= " + cr.nextDouble() + "\nA_COPY\t= " + anotherCopy.nextDouble() + "\n");
  }
}