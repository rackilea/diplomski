static int num = 2;
  static String text = "3";

  public static void up(WrapperClass w){
      //Debug
      System.out.println("Before Change");
      System.out.println("I: " + w.i);
      System.out.println("S: " + w.s);
      System.out.println("Num: " + num);
      System.out.println("Text: " + text);

      //Code
      w.i = w.i + 3;
      w.s = String.valueOf(w.i);

      //Debug
      System.out.println("After Change");
      System.out.println("I: " + w.i);
      System.out.println("S: " + w.s);
      System.out.println("Num: " + num);
      System.out.println("Text: " + text);
  }

  public static void main(String[] args) {
      WrapperClass w = new WrapperClass();
      w.i = num;
      w.s = text;
      up(w);

      //Debug
      System.out.println("Out of Scope");
      System.out.println("Num: " + w.i);
      System.out.println("Text: " + w.s);
  }


  static class WrapperClass {
    public int i;
    public String s;
  }