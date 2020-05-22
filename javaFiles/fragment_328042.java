class B { 
    public void p(String i) 
    { 
        System.out.println("parent:"+i); 
    } 
}

class A  extends B{ 
    public void p(int i) 
    { 
        System.out.println(i); 
    } 
} 
public class Test1 {
    public static void main(String args[]) {

         A a = new A(); //arg
            a.p(10);  
            a.p("sample"); 
    }
}