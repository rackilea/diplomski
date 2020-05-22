public static void main(String[] arg) {

    BigInteger zac = new BigInteger("3");
    zac = zac.pow(399);

    BigInteger kon = new BigInteger("3");
    kon = kon.pow(400);

    BigInteger nul = new BigInteger("0");
    BigInteger jed = new BigInteger("1");
    BigInteger detel = new BigInteger("3");

    for (BigInteger a = zac; a.compareTo(kon) <= 0; a = a.add(jed)) {

        BigInteger cis = a; // THIS A PROBLEM
        String retez = "";

        while (cis.compareTo(new BigInteger("0")) >= 0) {
            retez = (cis.mod(detel)) + retez;
            cis = cis.divide(detel);
            System.out.println(retez);
        }
    }
}