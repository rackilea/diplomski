class Top {
    public String f(Object o) {return "Top";}
}

class Sub extends Top {
    public String f(String s) {return "Sub";} // Overloading = No dynamic binding
    public String f(Object o) {return "SubObj";} // Overriding = Dynamic binding
}

public class Test {
    public static void main(String[] args) {  

                                  // Reference Type     Actual Type
        Sub sub = new Sub();      // Sub                Sub
        Top top = sub;            // Top                Sub
        String str = "Something"; // String             String
        Object obj = str;         // Object             String

                                        // At Compile-Time:      At Run-Time:
        // Dynamic Binding
        System.out.println(top.f(obj)); // Top.f (Object)   -->  Sub.f (Object)

        // Dynamic Binding
        System.out.println(top.f(str)); // Top.f (Object)   -->  Sub.f (Object)

        // Static Binding
        System.out.println(sub.f(obj)); // Sub.f (Object)        Sub.f (Object)

        // Static Binding
        System.out.println(sub.f(str)); // Sub.f (String)        Sub.f (String)
    }
}