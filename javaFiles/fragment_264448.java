WebDriver driver = new ChromeDriver(options);
LoginPage loginPage = new LoginPage(driver);

//One way:
loginPage.enterEmail("my@email.com").enterPassword("12345").submit();

// Another way:
loginPage.performLogin("my@email.com", "12345");