public class Simple {
    private String name = "Aman";
    private int trial;

    public static void main(String args[]) {
        Simple simple = new Simple();
        simple.trial = 8;
        System.out.println(simple.getName("foo", 1));
    }

    public String getName(String s, int i) {
        System.out.println("getName(" + s + ", " + i + ")");
        return name;
    }
}

public aspect Aspect11 {
    pointcut namePC(String s, int i) :
        call (public String Simple.getName(String, int)) && args(s,i);

    pointcut setData(int j) :
        set(int Simple.trial) && args(j);

    after(String s, int i) : namePC(s, i) {
        System.out.println("namePC: " + thisJoinPoint.getSignature());
    }

    before(int j) : setData(j) {
        System.out.println("setData: " + j);
    }
}