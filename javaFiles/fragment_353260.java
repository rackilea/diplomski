public class MyClass implements Comparable<MyClass> {

    private String cal;

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    @Override
    public int compareTo(MyClass o) {
        return new CompareToBuilder().append(this.cal, o.getCal()).toComparison();
    }
}