public static class Controller { 
    private static Form1 f1;
    private static Form2 f2;


    public static void showF1() {
         if(f1 == null) f1 = new Form1();
         f1.show();
    }

    // etc...
}