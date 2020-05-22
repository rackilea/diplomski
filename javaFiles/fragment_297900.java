enum MyEnum {
    EMPLOYEE_NUMBER("Employee number"),
    FIRST_NAME("First name");

    private String desc;

    MyEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static Optional<MyEnum> fromDesc(String desc) {
        return Stream.of(MyEnum.values()).filter(myEnum -> myEnum.getDesc().equals(desc)).findFirst();
    }

}