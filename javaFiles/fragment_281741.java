public class ShowInbox {

    public ShowInbox(WebDriver driver) {

        // ...
        driver.findElement(By.className(ElementNames.Inbox)).isDisplayed();
        System.out.println("Boîte de réception exists");
        driver.findElement(By.className(ElementNames.Inbox)).click();

        // ...
   }
}