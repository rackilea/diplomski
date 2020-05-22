public class MyPage extends WebPage {
  public MyPage() {
  }
  public void renderHead(IHeaderResponse response) {
    response.renderJavaScriptReference(new PackageResourceReference(YuiLib.class,
      "yahoo-dom-event/yahoo-dom-event.js"));
    response.renderCSSReference(new PackageResourceReference(AbstractCalendar.class,
      "assets/skins/sam/calendar.css"));
  }
}