public static void printSome() {
        IntStream.range(0, 100).forEach(i -> {
            System.out.println(String.format("Thread %d says:%d", Thread.currentThread().getId(), i));
            Thread.yield();
        });
    }