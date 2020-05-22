public class Temp {

    public String var1, var2, var3, var4;

    public void method1() {
        method3("m1_1", "m1_2", "m1_3", "m1_4");
    }

    public void method2() {
        method3("m2_1", "m2_2", "m2_3", "m2_4");
    }

    public void method3(String a, String b, String c, String d)
    { 
        var1 = a;
        var2 = b;
        var3 = c;
        var4 = d;    
    }
}