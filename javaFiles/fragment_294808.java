class RepeatedString {
    private String s;
    public RepeatedString(String s) {this.s = s;}

    public char charAt(long i) {
      return s.charAt((int)(i % s.length()));
    }

    public long count(char c, long i) {
      long n = 0;
      // how many complete repetitions?
      {
        long r = i / s.length();
        if (r > 0) {
          // count c in s
          for (int j = 0 ; j < s.length() ; j++) n += s.charAt(j) == c ? 1 : 0;
          n *= r;
        }
      }
      // how many c in last repitition
      {
        long l = i % s.length();
        for (int j = 0 ; j < l ; j++) n += s.charAt(j) == c ? 1 : 0;
      }
      return n;
    }
}

class Kata {

  public static void main(String[] args) {
    RepeatedString s = new RepeatedString("bla");

    System.out.println(s.charAt(1)); // expected 'l'
    System.out.println(s.charAt(6)); // expected 'b'

    System.out.println(s.count('a', 19)); // expected 6
    System.out.println(s.count('a', 21)); // expected 7
  }

}