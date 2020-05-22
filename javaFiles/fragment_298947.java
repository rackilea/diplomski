static class TestClass implements Serializable {
    private long a, b, c, d, e, f, g, h;

    public TestClass(long i) {
        a = i;
        b = a * i;
        c = b * i;
        d = c * i;
        e = d * i;
        f = e * i;
        g = f * i;
        h = g * i;
    }
}

public static void main(String[] args)  {
    for (int t = 0; t < 5; t++) {
        long start = System.currentTimeMillis();
        List<TestClass> list = LongStream.range(0, 100_000)
                .mapToObj(TestClass::new)
                .collect(Collectors.toList());
        long time = System.currentTimeMillis() - start;
        System.out.println("Created " + list.size() + " objects in " + time + "ms");

    }
}