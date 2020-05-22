public int headCount;
public int tailCount;
public int seed;

public Coin( int n ){
    seed = n;
    headCount = 0;
    tailCount = 0;
}
public Random flipGenerator = new Random(seed);