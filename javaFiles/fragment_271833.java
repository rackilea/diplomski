...
public class MyBackingBean {
...

private HtmlPanelGroup generatedElements = new HtmlPanelGroup();

public void init() {
     for (Element e : myElements) {
         // Take any element type you want
          HtmlOutputText subElement = new HtmlOutputText();
          subElement.setValue(e.getText());
          generatedElements.getChildren().add(subElement);
     }
}