// A.java
class A {
    private final String var;
    public A(){
        var = getVar();
        var.length();
    }
    private String getVar(){
        return "This is the value";
    }
}
class B extends A {
    private final String other;
    public B(){
        other = "Other string";
    }
    public String getVar(){
        return other;
    }
}
class Main{
    public static void main( String [] args ) {
        new B();
    }
}