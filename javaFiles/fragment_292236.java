public static void main (String[] args) throws java.lang.Exception
    {
        BigInteger biggestNumber = null;
        Scanner s = new Scanner(new FileReader(args[0]));
        while( s.hasNext() ){
            if( s.hasNextBigInteger() ){
                BigInteger number = s.nextBigInteger();
                if( biggestNumber == null || number.compareTo(biggestNumber) == 1 ){
                    biggestNumber = number;
                }
            }
            else {
                s.next();
            }
        }
        System.out.println("Biggest Number: " + biggestNumber.toString());
    }