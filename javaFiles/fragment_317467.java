public class PrimitiveCasting {
class anand {
    int a = 90;

    void anand1() {
        System.out.println("anand is having anand1");
    }
}

class babu extends anand {
    int c, b = 88;

    void babu1() {
        System.out.println("babu is having babu1");
    }
}

public static void main(String[] args) {
    System.out.println("**********");
    PrimitiveCasting primitiveCasting = new PrimitiveCasting();
    anand z1= primitiveCasting.new anand();
    z1.anand1();

    babu b1= primitiveCasting.new babu();
    b1.anand1();
    b1.babu1();
    System.out.println("********");
}