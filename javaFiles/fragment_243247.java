public class Program {
    public static void main(String[] args) {
        final int[] myInt = new int[1];
        tryParseInt("123", (rs, ex) -> {
            if (ex == null) {
                myInt[0] = rs;
            } else {
                ex.printStackTrace();
                System.exit(1);
            }
        });
        System.out.println("myInt = " + myInt[0]);
    }

    static void tryParseInt(String text, Callback<Integer, NumberFormatException> callback) {
        try {
            callback.publish(Integer.parseInt(text), null);
        } catch (NumberFormatException ex) {
            callback.publish(null, ex);
        }
    }
}

@FunctionalInterface
interface Callback<T, E extends Exception> {
    void publish(T result, E ex);
}