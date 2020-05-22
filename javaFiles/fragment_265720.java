class OuterClass {
    Runnable run;

    void method() {
       final int a = 8;
       this.run = new Runnable() {
          public void run() {
             System.out.println(a);
          }
       };
    }
 }