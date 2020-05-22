public static void main(String[] args) throws Exception {

    BigInteger p = BigInteger.probablePrime(4, new Random());

    BigInteger q = BigInteger.probablePrime(4, new Random());

    System.out.println("p: " + p.toString());
    System.out.println("q: " + q.toString());

    int k = 3;  // Receive k

    BigInteger trustedN = p.multiply(q);

    System.out.println("n: " + trustedN.toString());

    List<BigInteger> randomInts = new ArrayList<>();    //s1,s2...sk
    BitSet randomBits = new BitSet(k);  // b1,b2..bk
    List<BigInteger> listV = new ArrayList<>();

    Random rand = new Random();

    /*
    Choose k positive numbers less than trustedN.
    Choose k bits 0 or 1
     */
    System.out.print("random s: ");
    for (int i = 0; i < k; i++) {


        BigInteger si = new BigInteger(trustedN.bitLength() + 1, rand).mod(trustedN);

        while (si.gcd(trustedN).intValue() != 1){
            si = new BigInteger(trustedN.bitLength() + 1, rand).mod(trustedN);
        }
        // Generate random big ints less than trustedN
        randomInts.add(si);

        randomBits.set(i, rand.nextBoolean());
        // (-1)^bi
        System.out.print(randomInts.get(i) + " " + randomBits.get(i) + " ");
        BigInteger minus1pow = (((new BigInteger("-1")).pow(randomBits.get(i) ? 1 : 0)));

        // (s^2)^(-1)
        BigInteger randomIntPow = minus1pow.multiply(randomInts.get(i).pow(2)).modInverse(trustedN);

        // vi = (-1)^bi * (s^2)^(-1)//            listV.add((minus1pow.multiply(randomIntPow)).mod(trustedN));
        listV.add(randomIntPow);
    }
    System.out.print("\nlist v: ");
    for (BigInteger bi:
         listV) {
        System.out.print(bi.toString() + " ");
    }
    System.out.println();
    // Random r
    BigInteger randomR = new BigInteger(trustedN.bitLength() + 1, rand).mod(trustedN);
    System.out.println("r: " + randomR.toString());
    // Random bit index
    int bitIndex = (int) (Math.random() * ( randomBits.length()  ));
    System.out.println("bitIndex: " + bitIndex + " bit value: " + randomBits.get(bitIndex));
    // Calculate x//        BigInteger x = ((new BigInteger("-1")).pow(randomBits.get(bitIndex) ? 1 : 0).mod(trustedN)).multiply((randomR.pow(2)).mod(trustedN)).mod(trustedN);
    BigInteger x = (((new BigInteger("-1")).pow(randomBits.get(bitIndex) ? 1 : 0)).multiply((randomR.pow(2)))).mod(trustedN);
    // Let pretend it was randomly selected vector (e1,e2,e3)
    String eBits = "100";


    BigInteger totalMultS = new BigInteger("1");
    for (int i = 0; i < k; i++) {
        totalMultS = totalMultS
                .multiply(randomInts.get(i).pow(eBits.charAt(i) == '1' ? 1 : 0));
    }

    BigInteger y = totalMultS.multiply(randomR.mod(trustedN)).mod(trustedN);

    System.out.println("y: " + y.toString());


    BigInteger totalMultV = new BigInteger("1");

    for (int i = 0; i < k; i++) {
        totalMultV = totalMultV
                .multiply(listV.get(i).pow(eBits.charAt(i) == '1' ? 1 : 0));
    }

    System.out.println("total mult v: " + totalMultV);


    if ((z.toString().equals(x.toString()) || z.toString().equals(x.negate().mod(trustedN).toString()))
            && !z.toString().equals("0")){
        System.out.println("SUCCESS");

    }
    else {
        System.out.println("FAIL");

        System.out.println("x: " + x.toString());
        System.out.println("z: " + z.toString());

    }

}