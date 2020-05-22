public class TestDriver {
    public static void main(String[] args) {
        MyStringLog animals = new MyStringLog("animals");
        animals.insert("dog");
        animals.insert("cat");

        System.out.println(animals.toString());
    }
}