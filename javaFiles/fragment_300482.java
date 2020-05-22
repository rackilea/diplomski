public enum MyEnum {
    FIELD1(MyPojo::getField1),
    FIELD2(MyPojo::getField2),
    FIELD3(MyPojo::getField3);

    private final Function<MyPojo, String> getField;

    MyEnum(Function<MyPojo, String> getField) {
        this.getField = getField;
    }

    String getFieldFromMyPojo(MyPojo myPojo) { return getField.apply(myPojo); }
}