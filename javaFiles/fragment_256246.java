if(commentsbutton.size() > 0) {
    for (WebElement element : commentsbutton) {
        element.click(); //click on button if found
        Thread.sleep(5000); //pause for 5 seconds
    }
}