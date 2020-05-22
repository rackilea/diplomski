public class Mcve {
    public Mcve(String s) throws Exception {
        // whatever
    }

    public static void main(String[] args) {
        Function<String, Mcve> mcveFactory = parameter -> {
            try {
                return new Mcve(parameter);
            } catch (Exception e) {
                throw new RuntimeException(e); // or ignore
            }
        };
    }
}