static List<MyEnum> list = new ArrayList<>();

static {
    for (MyEnum myEnum : MyEnum.values()) {
        list.add(myEnum);
    }
    // list.get(0) == MyEnum.A, list.get(1) == MyEnum.B
}