public class Benchmark {
    private void start() {
        //setup byte arrays
        List<byte[]> arrays = createByteArrays(700_000);

        //warmup and benchmark repeated
        arrays.forEach(this::byteArrayCheck12);
        benchmark(arrays, this::byteArrayCheck12, "byteArrayCheck12");

        arrays.forEach(this::byteArrayCheck3);
        benchmark(arrays, this::byteArrayCheck3, "byteArrayCheck3");

        arrays.forEach(this::byteArrayCheck4);
        benchmark(arrays, this::byteArrayCheck4, "byteArrayCheck4");

        arrays.forEach(this::byteArrayCheck5);
        benchmark(arrays, this::byteArrayCheck5, "byteArrayCheck5");
    }

    private void benchmark(final List<byte[]> arrays, final Consumer<byte[]> method, final String name) {
        long start = System.nanoTime();
        arrays.forEach(method);
        long end = System.nanoTime();
        double nanosecondsPerIteration = (end - start) * 1d / arrays.size();
        System.out.println("Benchmark: " + name + " / iterations: " + arrays.size() + " / time per iteration: " + nanosecondsPerIteration + "ns");
    }

    private List<byte[]> createByteArrays(final int amount) {
        Random random = new Random();
        List<byte[]> resultList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            byte[] byteArray = new byte[4096];
            byteArray[random.nextInt(4096)] = 1;
            resultList.add(byteArray);
        }
        return resultList;
    }

    private boolean byteArrayCheck12(final byte[] array) {
        int sum = 0;
        for (byte b : array) {
            sum |= b;
        }
        return (sum == 0);
    }

    private boolean byteArrayCheck3(final byte[] array) {
        for (byte b : array) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean byteArrayCheck4(final byte[] array) {
        return (IntStream.range(0, array.length).map(i -> array[i]).reduce(0, (a, b) -> a | b) != 0);
    }

    private boolean byteArrayCheck5(final byte[] array) {
        return IntStream.range(0, array.length).map(i -> array[i]).anyMatch(i -> i != 0);
    }

    public static void main(String[] args) {
        new Benchmark().start();
    }
}