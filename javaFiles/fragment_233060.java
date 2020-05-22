public static void main (String[] args) throws java.lang.Exception
{
     String s = "0 - 22 1985--324"; // => 022-198-53-24
     run(s);
     s = "555372654";  // => 555-372-654
     run(s);
     s = "12-10 23 5555 8361"; // => 121-023-555-583-61
     run(s);
}
public static void run(String abc) {
    String hello = abc.replaceAll("[^a-zA-Z0-9]", "");
    hello = hello.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
    System.out.println(hello.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3"));
}