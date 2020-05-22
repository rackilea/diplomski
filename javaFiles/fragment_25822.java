public class Test {

    public static void main(String[] args) {
        BagOfPrimitives obj = new BagOfPrimitives();
        System.out.println(obj.value1 + obj.value2 + obj.value3);
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));
    }

    static class BagOfPrimitives {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;
        BagOfPrimitives() {
            // no-args constructor
        }
    }

}