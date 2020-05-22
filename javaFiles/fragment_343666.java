class X{
    X(){
        super(); // Injected by compiler
        System.out.println("Inside X()");
    }
    X(int x){
        super(); // Injected by compiler
        System.out.println("Inside X(int)");
    }
}
class Y extends X{
    Y(String s){
        super(); // Injected by compiler
        System.out.println("Inside Y(String)");
    }
    Y(int y){
        super(1000);
        System.out.println("Inside Y(int)");
    }
}
class Z extends Y{
    Z(){ 
        super(); // Injected by compiler
        System.out.println("Inside Z()");
    }
    Z(int z){
        super(100);
        System.out.println("Inside Z(int)");
    }
}
public class Program{
    public static void main(String args[]){
        Z z=new Z(10);
    }
}