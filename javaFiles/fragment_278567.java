interface F0 {
    void f0();
}
interface F1 {
    void f1(MetRef i1);
}
interface F2 {
    void f2(MetRef i1, MetRef i2);
}

public class MetRef {
    public static void stat0() {;}
    public static void stat1(MetRef a) {;}
    public static void stat2(MetRef a, MetRef b) {;}

    public void inst0() {;}
    public void inst1(MetRef a) {;}
    public void inst2(MetRef a, MetRef b) {;}
}