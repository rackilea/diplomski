private static final int[] RANKING_FACTORS = {4826809, 371293, 28561, 2197, 169, 13, 1};

@Test
public void testDecode() {
    long value = 357451;
    int[] rankings = new int[6];
    //System.out.println(Math.max(0,value-RANKING_FACTORS[0]));
    for (int i=0; i < rankings.length; i++) {
        rankings[i] = (int)(value / RANKING_FACTORS[i]);
        value %= RANKING_FACTORS[i];
        System.out.println(rankings[i]);
    }
}