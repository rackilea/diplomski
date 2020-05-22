public interface EnunConstants {
    int STATIK = 1;
    int AWESOME = 2;
    int POSSUM = 3;

}

public enum Enum implements EnunConstants {
    A(STATIK),
    B(AWESOME),
    C(POSSUM);

    private int val;

    private Enun(final int i) { this.val = i; }
    public int getVal() { return val; }

}

public class Sergio {

    public static void main(String[] args) {
        Enun S = Enun.A;
        System.out.println(S.getVal());
        Enun P = Enun.C;
        System.out.println(P.getVal());

    }

}