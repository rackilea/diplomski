private Runnable generateRunnablePrinter(final int value) {
    return new Runnable() {
       public void run() {
           System.out.println(value);
       }
    };
}