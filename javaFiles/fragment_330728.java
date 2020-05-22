@BeforeMethod
public void Gexlogin() {
     LoginPF objLogin=PageFactory.initElements(BrowserFactory.driver, LoginPF.class);
     System.out.println("Logging into GEx");
     objLogin.loginToDGEx(userName, password); //changed to instance variables
     System.out.println("Successfully Logged into GEx");
}