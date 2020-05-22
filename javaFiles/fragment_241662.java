public class TestImpl implements Test {

    @override
    public Collection<String> findAll() {
        return null;
    }

    public static void main(String[] args) {
        Test test = new TestImpl();
        test.findAll();
    }
}