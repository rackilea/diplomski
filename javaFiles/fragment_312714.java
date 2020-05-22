@Builder(builderMethodName = "buildTest")
public static void test(User bar, Item item){
    // ...
}

public void buildTestExample(){
    buildTest()
            .user(new User())
            .item(new Item())
            .build();
}