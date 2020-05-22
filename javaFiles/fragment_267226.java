public aspect Aspect {

    pointcut outerMethod(String arg1, String arg2, int arg3) : 
        execution(public void Y.fY(String,String,int)) && 
        args(arg1, arg2, arg3); 

    pointcut innerMethod() : call(public void X.fX(int, String));

    after(String arg1, String arg2, int arg3) : 
        cflow(outerMethod(arg1, arg2, arg3)) &&
        innerMethod() {
        System.out.println("I'm here!!!");
        System.out.println(arg1 + " " + arg2 + " " + arg3);
    }

    public static void main(String[] args) {
        Y.fY("a", "b", 1);
    }
}

class X {
    public static void fX(int i, String s) {

    }
}

class Y {
    public static void fY(String arg1, String arg2, int arg3) {
        X.fX(1, "testY");
    }
}