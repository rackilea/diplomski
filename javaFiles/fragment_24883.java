public int h = 44;
  public int getH()
  {
    System.out.println("Beta "+h);         // print line 1
    return h;
  }
  public static void main(String[] args)
  {
    Baap b = new Beta();
    System.out.println(b.h+" "+b.getH());  // print line 2
    Beta bb = (Beta) b;
    System.out.println(bb.h+" "+bb.getH()); // print line 3
  }