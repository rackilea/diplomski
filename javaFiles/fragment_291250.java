public class Test {
    static int DATA = 42;
    static int getData() {
        return DATA;
    }
    static void setData(int i) {
        DATA=i;
    }
}

increment(Test::getData, Test::setData);
System.out.println(DATA);