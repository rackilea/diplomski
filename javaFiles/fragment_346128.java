//Clicking on the Browse button
    driver.findElement(By.xpath("//input[@type='file']")).click();

    //Setting the Clipboard contents
    StringSelection path = new StringSelection("C:\\Users\\user\\Desktop\\Ontology.owl");//the code needed to be pasted in the second dialog box 
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

    Thread.sleep(4000);//Sleep time to detect the window dialog box

    //Pasting the path in the File name field
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    //To click the Open button so as to upload file
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

    //Click on Upload button
    driver.findElement(By.xpath("//input[@value='Upload']")).click();