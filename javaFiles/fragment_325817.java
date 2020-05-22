public User transform(DataTable dataTable) throws Throwable {
    return new User(dataTable.asMaps().get(0));
}

@When("I Log In As Valid User")
public void I_Log_In_As_Valid_User(@Transpose SilverUser user) throws Throwable {
    System.out.println(user);
}