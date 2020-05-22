public static class Weird
{
    private final String suffix;

    private final Function<String, String> addSuffix = new Function<String, String>() {
        @Override
        public String apply(String text) {
            return String.format( "%s.%s", text, suffix );
        }
    };

    public final String s = addSuffix.apply("1");

    public static void main(String[] args) {
        System.out.println(new Weird("p").s);
        // 1.null (!!)
    }
}