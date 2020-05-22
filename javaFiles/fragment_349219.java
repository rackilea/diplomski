public static void main( String args[] ){
      // create random object
      Random r = new Random();

      int numBits = 64;
      int numBytes = numBits/8;

      // create the byte array
      byte[] genes = new byte[numBytes];

      //fill it
      r.nextBytes(genes);

      //print it
      System.out.println("byte array: " + genes);

      //now convert it to a 64-bit long using BigInteger          
      long l = new BigInteger(bytes).longValue();

      //print it
      System.out.println("long: " + l);
  }