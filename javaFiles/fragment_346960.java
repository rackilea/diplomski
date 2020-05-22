public static void main (String args[]) {
    String source = "19/03/2016 16:34";
    String result = source.substring(1, 3);
    System.out.print(result);
    //equivalent to the previous System.out.println call
    System.out.print(source.substring(1, 3));
}