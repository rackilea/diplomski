public class StringFormatBenchmark extends SimpleBenchmark {

    public void timeStringFormat(int reps) {
        while (--reps >= 0) {
            String s = String.format("test %d", reps);
        }
    }

    public void timeStringBuilder(int reps) {
        while (--reps >= 0) {
            String s = new StringBuilder("test ").append(reps).toString();
        }
    }

    public void timeStringBuffer(int reps) {
        while (--reps >= 0) {
            String s = new StringBuffer("test ").append(reps).toString();
        }
    }

    public void timeStringPlusOperator(int reps) {
        while (--reps >= 0) {
            String s = "test " + reps;
        }
    }

    public void timeReplace(int reps) {
        while (--reps >= 0) {
            String s = "test {}".replace("{}", String.valueOf(reps));
        }
    }

    public void timeStringConcat(int reps) {
        while (--reps >= 0) {
            String s = "test ".concat(String.valueOf(reps));
        }
    }

    public static void main(String[] args) {
        new Runner().run(StringFormatBenchmark.class.getName());
    }

}