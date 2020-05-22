public class Test {

    public static void main(String[] args) {
        // some dummy data
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; ++i) list.add(i);

        // to simulate some CPU intensive work
        Random random = new SecureRandom();

        List<String> result = list.parallelStream().map(i -> {

            // simulate work load
            int millis = 0;
            try {
                millis = random.nextInt(1000);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // return any desired result
            return "Done something with " + i + " in thread " + Thread.currentThread().getName() + " took " + millis + "ms";
        }).collect(Collectors.toList()); // collect joins - will return once all the workers are done

        // print the result
        result.forEach(System.out::println);    
    }
}