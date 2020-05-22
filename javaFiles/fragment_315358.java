try {
    WebElement script = driver.findElement(By.tagName("script"));
    String scriptText = script.getText(); //returns the text of <script> tag
    if (scriptText.contains("access denied")) System.out.println("Access Denied!");
    else System.out.println("Access granted");
} catch (NoSuchElementException e) {
    System.out.println("Script does NOT exist!");
}