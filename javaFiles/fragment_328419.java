public class Program {
    public static void main(String[] args){
        MyInterface myVar = new MyInterface(){ 
            public void myMethod(){ 
                System.out.println("hello World"); 
            }
        };
        myVar.myMethod();
    }

    private interface MyInterface{
        void myMethod(); 
    }
}