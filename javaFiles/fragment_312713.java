@Builder
public static void test(User user, Item item){
    // ...
}

public void buildTestExample(){
    builder()
            .user(new User())
            .item(new Item())
            .build();
}