public static void main(String[] args) {
    String Str = "(1036)\"General Project\"";
    String[] arr =Str.split("\\)");
    String s = arr[arr.length-1];
    System.out.println(s);
}