public static void main(String args[]){
     long multiplier = 0x5DEECE66DL;

    long addend = 0xBL;

     long mask = (1L << 48) - 1;

    long seed = 128856;
    Random random = new Random(seed);
    long n1 = random.nextInt();
    long n2 = random.nextInt();
    long n3 = random.nextInt();

    System.out.println("Results: " + n1 +" "+ n2 +" "+ n3);


    System.out.println("seed: " + seed);
    long seed0 = (seed ^ multiplier) & mask;
    System.out.println("seed0: " + seed0);

    long seed1 = ((seed0 * multiplier + addend) & mask);
    System.out.println("seed1: " + seed1);
    int v1 = (int)(seed1 >>> 16);
    System.out.println("v1: " + v1);

    long seed2 = ((seed1 * multiplier + addend) & mask);
    System.out.println("seed2: " + seed2);
    int v2 = (int)(seed2 >>> 16);
    System.out.println("v2: " + v2);
}