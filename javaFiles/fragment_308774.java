public class A implements Cloneable {
    int value;
    String name;

    public A(int x, String str) {
        this.value = x;
        this.name = str;
    }

    @Override
    public A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }

    public boolean equals(A elem) {
        return (this.name).equals(elem.name) && this.value == elem.value;
    }
}