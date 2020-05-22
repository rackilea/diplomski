public void getquote() {

        String firstName = "Sam";
        String lastName = "Gayle";
        String email = "somename@somename.com";
        String password = "test1234";

        CallGetQuote(FirstName, LastName, Email, Password);

    }

    public void CallGetQuote(String... var) {

        // add your elements to a List
        List<MyElements> inputElements = new ArrayList<MyElements>;

        inputElements.add(driver.findElement(By.id("first-name")));
        inputElements.add(driver.findElement(By.id("last-name"))); 
        inputElements.add(driver.findElement(By.id("join-email")));  
        inputElements.add(driver.findElement(By.id("join-password")));

        // iterate over the List to send keys
        for (int i = 0; i < var.length; i++) {
        inputElements.get(i).sendKeys(var[i]);
    }
    }