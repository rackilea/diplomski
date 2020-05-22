public class DataClassAdapter {
    DataClass wrappedInstance;

    public void doOperation() {
        wrappedInstance.data.doOperation();
    }
}