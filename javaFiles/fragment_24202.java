public interface Inter {
    <T extends Enum<T> & FunctionalInterface> String getString(T value);
}

static class InterImpl implements Inter {
    @Override
    public <T extends Enum<T> & FunctionalInterface> String getString(T value) {
        return value.name();
    }
}

enum EnumImpl implements FunctionalInterface {
    A, B, C;

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

public static void main(String[] args) {
    InterImpl impl = new InterImpl();
    System.out.println(impl.getString(EnumImpl.B));
}