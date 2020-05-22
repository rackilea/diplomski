protected boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }

String s[] = {"test comment1", "test comment2"};
        for(int i =0; i<s.length; i++){
            driver.findElement(By.name("comment_body[und][0][value]")).sendKeys(s[i]);
            driver.findElement(By.xpath("//a[@onclick='commnet_form_submit_handler(); return false;']")).click();
            assertTrue(isTextPresent(s[i]));
        }