public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(Test.class.getResourceAsStream("input.txt"));
    int size = in.nextInt();
    String inputLine = in.nextLine();
    System.out.println(size); // prints "10"
    System.out.println(inputLine); // prints nothing

    inputLine.trim();
    int posn = inputLine.indexOf('\"');
    int nextPosn = inputLine.indexOf('\"', posn + 1);
    String author = inputLine.substring(posn, nextPosn); // Throws: "java.lang.StringIndexOutOfBoundsException: String index out of range: -1"
}