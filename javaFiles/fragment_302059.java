public static void main (String[] args) throws java.lang.Exception
{
    String regex = "354\\s.+";
    System.out.println("354 adfjdakl".matches(regex));
    System.out.println("354asl;dfa".matches(regex));
}