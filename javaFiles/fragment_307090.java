public class TestObj {
    int key;
    String a;
    String b;
    String c;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    TestObj(int key, String A, String B, String C){
        this.key=key;
        this.a=A;
        this.b=B;
        this.c=C;
    }
}