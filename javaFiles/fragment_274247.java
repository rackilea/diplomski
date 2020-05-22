public class MediocreExample {
    List<String> strings;
    private void initialize () {
        strings = new List<String>();
        strings.add("first");
        strings.add("second");
    }
    public MediocreExample () {
        initialize();
        ...
    }
    public MediocreExample (int parameter) {
        initialize();
        ...
    }
}