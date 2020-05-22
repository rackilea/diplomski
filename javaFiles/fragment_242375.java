public static void main(String[] args) {
    String s = "work";
    char[] arr = new char[10];
    System.arraycopy(s.toCharArray(), 0, arr, 0, s.toCharArray().length );
    System.out.println(arr.length); // prints 10
    System.out.println(arr); // prints work
}