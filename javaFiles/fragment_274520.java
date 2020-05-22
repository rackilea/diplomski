class EncodeNegaBinary {

  public static void main(String[] args) {

    int n=0,input=0;
    String result="";
    final String[] BITS = { "0","1" };

    if (args.length != 1) {
      System.err.println("Please enter an integer to be converted");
      return;
    } else {
      input = n = Integer.parseInt(args[0]);
    }

    while (n != 0) {
      int r = n%-2;
      n /= -2;
      if (r == -1) {
        r=1;
        n++;
      }
      result = BITS[r] + result;
    }

    System.out.printf( "%d -> %s\n", input, result);

  }
}