public class Example {
    ? field1;        // invalid
    List<?> field2;  // valid

    private ? method1(? param) {return param;}              // invalid
    private List<?> method2(List<?> param) {return param;}  // valid

    private void method3() {
        ? var1;        // invalid
        List<?> var2;  // valid
    }
}