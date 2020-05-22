public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriver driver = new FirefoxDriver();
        driver.get("file:///C:/Users/rajnish/Desktop/my.html");

        // way one
        // you can create your custom x path
        // one x path can be made directly using id of the span like 
        // xpath =  //span[@id='spnLogCount']
        // also not if you are not sure of the tag name then you can also use * in xpath like below
        String myText = driver.findElement(By.xpath("//*[@id='dvCount']/span[2]")).getText();
        System.out.println("Total Log Count :  " + myText);

        // way two
        // you can directly use id 
        myText = driver.findElement(By.id("spnLogCount")).getText();
        System.out.println("Total Log Count :  " + myText);

        // way three
        // if you are using css selector then for id you can use #
        myText = driver.findElement(By.cssSelector("#spnLogCount")).getText();
        System.out.println("Total Log Count :  " + myText);

    }