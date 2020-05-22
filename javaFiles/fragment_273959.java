enum MyEnum {
    FOO, BAR;

    private MyEnum() {
        System.out.println("Initializing");
    }
}

public static void main(String[] args) {
    System.out.println(MyEnum.FOO);
}