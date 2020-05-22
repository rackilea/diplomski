public class A{
    private B b;
    private String f2;
    private String f3;

    public A(String f1,String f2,String f3){
        b = new B(f1);
        this.f2 = f2;
        this.f3 = f3;
        System.out.println("In A->B:"+getB().getF1()+":A:f2:"+f2+":A:f3:"+f3);
    }
    public B getB(){
        return this.b;
    }
    public static void main(String args[]){
        if (args.length < 3) {
            System.out.println("Usage: java A str1 str2 str3");
            return;
        }
        A a = new A(args[0],args[1],args[2]);

    }

}
class B{
    private String f1;
    public B(String f1){
        this.f1 = f1;
    }
    public String getF1(){
        return this.f1;
    }
}



java A apple banana camel

 In A->B:apple:A:f2:banana:A:f3:camel