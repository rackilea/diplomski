//add this line
    if (!selenium.isElementPresent("//*[@id='content']/p[2]/span/font/b")){
    Thread.sleep(2000);
    }
    // verify if the result is 5
    String result = selenium.getText("//*[@id='content']/p[2]/span/font/b");
    System.out.println(result);

    //update this line
    if (result.trim().equals("5"))
    {
        System.out.println("Pass");
    }else
    {
        System.out.println("Fail");
    }