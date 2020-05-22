Scanner input = new Scanner(System.in);
String other = input.nextLine();
if (other.matches("\\d+\\.\\d+")) {
    //your input is double
    Double d = Double.parseDouble(other);
    System.out.println("double = " + d);

} else {
    //your intput is a Strings
    System.out.println(other);
}