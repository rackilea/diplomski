@DataProvider
public Object[][] getUsers() {
    int[][] multi = new int[][]{
       { 0, new User("Tom") },
       { 0, new User("Sally") }
    };
    return multi;
}

@BeforeMethod
public void setupBeforeEachTest(Object[] args) {
    User x = (User)args[1];
    x.modify();
}

@Test(dataProvider = "getUsers")
public void test1(User user) {
    assertSomething(user);
}

@Test(dataProvider = "getUsers")
public void test2(User user) {
    assertSomethingElse(user);
}