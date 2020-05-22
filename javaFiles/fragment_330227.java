class Example {
    static void test(String code, String... s) {
        System.out.println("code: " + code);
        if(s == null) {
            System.out.println("array is null");
            return;
        }
        for(String str: s) {
            if(str != null) {
                System.out.println(str);
            } else {
                System.out.println("element is null");
            }
        }
        System.out.println("---");
    }

    public static void main(String... args) {
        /* the array will contain two elements */
        test("numbers", "one", "two");
        /* the array will contain zero elements */
        test("nothing");
        /* the array will be null in test */
        test("null-array", (String[])null); 
        /* first argument of the array is null */
        test("one-null-element", (String)null); 
        /* will produce a warning. passes a null array */
        test("warning", null);
    }
}