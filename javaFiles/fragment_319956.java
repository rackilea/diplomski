class Test {
  public static void main(String[] args) {
    char[] foo = args[0].toLowerCase().toCharArray();
    System.out.print("Lowercase " + args[0] + " has " + foo.length + " chars: ");
    for(int i=0; i<foo.length; i++) System.out.print("0x" + Integer.toString((int)foo[i], 16) + " ");
    System.out.println();
  }
}