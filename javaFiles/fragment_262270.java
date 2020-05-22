@Block(@FindBy(xpath = "//tr[contains(@class,'bg-success')]"))
public class ShareContentRowBlock extends HtmlElement {

   @FindBy(xpath = ".//h3[@class='fileName']/span/a")
   private TextBlock contentNameText;

   public String getContentName() {
       return contentNameText.getText();
   }

   .... // some other elements and methods
}