public class Test {
    static class Foo {   // <---- Notice the static class
        int[] arr;
        Foo(int[] userInput) {
            arr = userInput;
        }
    }
    public static void main(String[] args) {
        int[] userInput = new int[]{1,2,3,4,5};
        Foo instance = new Foo(userInput);
    }
}