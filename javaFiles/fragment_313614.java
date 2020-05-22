public interface Command<T, U> {
    public U execute(T t);
}

class CheckGenerics {

    public static void main(String[] args) {

        Command<Object, Class<Void>> command1 = new Command<Object, Class<Void>>() {

            @Override
            public Class<Void> execute(Object t) {

                return Void.TYPE;

            }
        };

        Command<Object, Object[]> command2 = new Command<Object, Object[]>() {

            @Override
            public Object[] execute(Object t) {

                return new Object[] { t };
            }

        };

        Class<Void> a = command1.execute(new Object());
        System.out.println(void.class == a); // prints true

        Object[] b = command2.execute(new Object());
        System.out.println(b);

    }