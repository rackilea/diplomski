public static void main (String[] args) throws java.lang.Exception
{
    String s = "foobar42";
    int l = (int)(Math.random()*s.length());
    char ch = s.charAt(l);
    System.out.println(ch);
}