private int x=10;

     public void m1(int x) {
      sysout(this.x)//would print 10 member variable
      sysout(x); //would print 5; local variable
      } 

   public static void main(String..args) {
      new classInst().m1(5);

   }