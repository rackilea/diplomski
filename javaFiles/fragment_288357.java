public class Class1 implements Interface1 {       
    public Class1() {
        //some init
    }

    @Override
    public Object method1(String param1) {
        //some code
        return null;
    }

    @Override
    public void method2(String param1,String param2) {
        //some code
    }         
}


 interface Interface1 extends Interface2 {       
     //some specific code
}


 interface Interface2 {
    public Object method1(String param1);
    public void method2(String param1,String param2);
}