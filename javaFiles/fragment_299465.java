class Bla {
  public static void main(String[] args) {
    (new Runnable() {
      public void run() {
        System.out.println(getClass().getName()); // prints Bla$1
      }
    }).run();
  }
}