public class Main
{
    public static void main(String ... args)
    {
        TestParamA<D,E,String> a = new TestParamA<>().new Builder<>("a","b","c").withD(new D()).withE(new E()).build();
        TestParamB<F,G,String> b = new TestParamB<>().new Builder<>("a","b","c").withF(new F()).withG(new G()).withOptionalZ("z").build();
        TestParam<String> c = new TestParamA<>().new Builder<>("a","b","c").withD(new D()).withE(new E()).withOptionalZ("z").build();
        TestParam<?> d = new TestParamB<>().new Builder<>("a","b","c").withF(new F()).withG(new G()).build();

        test(a);
        test(b);
        test(c);
        test(d);

        TestParam<?>.CommonBuilder<? extends TestParam<?>.CommonBuilder<?>> builder = 
            new TestParamA<>().new Builder<>("a", "b", "c").withD(new D()).withE(new E());
        test(builder);
        // or a bit shorter
        TestParam<?>.CommonBuilder<?> builder2 = 
            new TestParamB<>().new Builder<>("a", "b", "c").withF(new F()).withG(new G());
        test(builder2);
    }

    public static void test(TestParamA<?,?,?> testParam)
    {
        System.out.println("Test for ParamA: " + testParam.toString());
    }

    public static void test(TestParamB<?,?,?> testParam)
    {
        System.out.println("Test for ParamB: " + testParam.toString());
    }

    public static void test(TestParam<?> testParam)
    {
        System.out.println("Test for Param: " + testParam.toString());
    }

    public static void test(TestParam<?>.CommonBuilder<?> builder)
    {
        System.out.println("Test for CommonBuilder: " + builder.build().toString());
    }
}