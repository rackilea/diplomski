public class GetKthTest {
int[] sorted1;
int nbr = 8000000;
private int k = 50;

@Before
public void setUp() {
    sorted1 = new int[nbr];
    Random rand = new Random();
    for (int i = 0; i < nbr; i++) {
        sorted1[i] = rand.nextInt();
    }
    Arrays.sort(sorted1);

}

@Test
public void hundredThous() {
    long start = System.currentTimeMillis();
    System.out.println(sorted1[k]);
    System.out.println("Time in ms: " + (System.currentTimeMillis() - start));
}

}