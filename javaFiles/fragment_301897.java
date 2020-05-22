// Please don't write code like this. It's horrible.
class Super {
   public int x;
}

class Sub extends Super {
    public int x;

    public Sub() {
        x = 10;
        super.x = 5;
    }

}

public class Test {
    public static void main(String[] args) {
        Sub sub = new Sub();
        Super sup = sub;
        System.out.println(sub.x); // Prints 10
        System.out.println(sup.x); // Prints 5
    }
}