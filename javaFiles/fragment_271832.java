public class Sample 
{ 
    public static void main(String [] args) { 
        A obj = new B(); 
        System.out.println(obj.a); // prints 10
        System.out.println(((B)obj).a); // prints 20
    } 
}