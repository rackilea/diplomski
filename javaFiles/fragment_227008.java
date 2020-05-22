public class TypeTest {
    public static void main(String[] args) {
        AType<Integer> type0 = Types.SOME_TYPE_0.instantiate();
        type0.setValue(10);

        AType<String> type1 = Types.SOME_TYPE_1.instantiate();
        type1.setValue("foo");
    }
}