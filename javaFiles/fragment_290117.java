public class MyBenchmark {
    public static Predicate<Object> normal = MyBenchmark::isNull;
    public static Method reflectionInvoke;
    public static Predicate<Object> reflectionWrappedPredicate;
    public static Predicate<Object> reflectionReturnedPredicate;

    static {
        try {
            Method m1 = MyBenchmark.class.getMethod("isNull", Object.class);
            reflectionInvoke = m1;
            reflectionWrappedPredicate = a -> {
                try {
                    return (boolean)m1.invoke(null, a);
                }
                catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    return false;
                }
            };

            Method m2 = MyBenchmark.class.getMethod("isNull");
            reflectionReturnedPredicate = (Predicate)m2.invoke(null);
        }
        catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            ex.printStackTrace();
        };
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public boolean testNormal() {
        Predicate<Object> p = normal;
        return p.test(this) | p.test(null);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public boolean testReflectionInvoke() {
        try {
            Method m = reflectionInvoke;
            return (boolean)m.invoke(null, this) | (boolean)m.invoke(null, (Object)null);
        }
        catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public boolean testReflectionWrappedPredicate() {
        Predicate<Object> p = reflectionWrappedPredicate;
        return p.test(this) | p.test(null);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public boolean testReflectionReturnedPredicate() {
        Predicate<Object> p = reflectionReturnedPredicate;
        return p.test(this) | p.test(null);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static Predicate<Object> isNull() {
        return obj -> obj == null;
    }
}