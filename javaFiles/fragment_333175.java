public class A{
    private int i=10;

    public void name(){   
        System.out.println("A");
    }

    public int getI(){
        return i;
    }
}

public class B extends A{
    private int i=20;

    public void name(){        
        System.out.println("B");
    }

    @Override
    public int getI(){
        return i;
    }
}  

public class HelloWorld { 

    public static void main(String[] args){
        A a = new B();
        a.name();
        System.out.println(a.getI());
    }

}