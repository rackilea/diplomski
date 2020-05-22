public String readFromConsole() {
    String result ;
    Scanner in = new Scanner(System.in);
    result = in.nextLine();
    return result+System.getProperty("line.separator");
}