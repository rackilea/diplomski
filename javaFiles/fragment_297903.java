enum MyEnum {
    EMPLOYEE_NUMBER("Employee number"),
    FIRST_NAME("First name");

    private static final Map<String, MyEnum> cacheByDesc;
    static {
        cacheByDesc = Stream.of(MyEnum.values()).collect(Collectors.toMap(MyEnum::getDesc, e -> e));
    }

    private String desc;

    MyEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static Optional<MyEnum> fromDesc(String desc) {
        return Optional.ofNullable(desc)
                .map(cacheByDesc::get);
    }

}