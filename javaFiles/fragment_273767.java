class Main {
  public static void main(String[] args) {
    String line = "!café hello world hello2 !xxx hello3, %643,!xxxxxxx. world5, !";
    String pure = line.replaceAll("!\\p{L}+", "");
    System.out.println(pure);
  }
}