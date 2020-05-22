Callable<String> c = () -> {
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(
            ThreadLocalRandom.current().nextInt(50, 300)));
    return "Completed on "+Thread.currentThread().getName();
};
String result = c.call();
System.out.println(result);