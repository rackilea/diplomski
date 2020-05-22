public class Element {
    float x;
    float x2;
    float result;
    String performance;

    public Element(float x, float x2, float result, String performance) {
        this.x = x;
        this.x2 = x2;
        this.result = result;
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Element{" + "x=" + x + ", x2=" + x2 + ", result=" + result + ", performance=" + performance + '}';
    }
}