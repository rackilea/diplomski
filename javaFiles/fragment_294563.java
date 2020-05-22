private <T> T login(String user, String pw, Class<T> expectedPage){
    username.sendKeys(user);
    password.sendKeys(pw);
    submitButton.click();
    return PageFactory.initElements(driver, expectedPage);
}

public AdminWelcome loginAsAdmin(String user, String pw){
    return login(user, pw, AdminWelcome.class);
}

public CustomerWelcome loginAsCustomer(String user, String pw){
    return login(user, pw, CustomerWelcome.class);
}

public Login loginWithBadCredentials(String user, String pw){
    return login(user, pw, Login.class);
}