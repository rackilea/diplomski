public class Test
{
    private static void test(String input, boolean expected)
    {
        boolean result = input.matches("([123456789TJQKA])([dchs])\\1(?!\\2)[dchs]|([123456789TJQKA])\\3");
        if (result != expected)
            throw new RuntimeException("Failed!");
    }

    public static void main(String[] args) throws Exception
    {
        test("JJ", true);
        test("JsJd", true);
        test("11", true);
        test("2c2h", true);

        test("Js", false);
        test("JsJs", false);
        test("JsJ", false);
        test("JQ", false);
        test("1d1d", false);
        test("J", false);
        test("", false);
        test("3d3d", false);
        test("JsJdJ", false);
        test("JsJdJh", false);
        test("1A", false);
    }
}