public class App{
public static void main(String[] args) {
   String s1 = new String("str");
   String s2 = new String("str");
    System.err.println("why it,s "+String.valueOf(s1==s2));
    Integer i1 = new Integer(10);
    Integer i2 = new Integer(10);
    System.err.println("why it,s "+String.valueOf(i1==i2));
}   
}