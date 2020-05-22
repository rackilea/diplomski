public class Exampel {
    public publicMethod(final Integer i) {
        if (i == null) {
            throw new RuntimeException("i should not be null");
        }

        privateMethod(i):
    }

    private privateMethod(final Integer i) {
        assert i != null;

        // do something
    }
}