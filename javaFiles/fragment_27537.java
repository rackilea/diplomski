@Import(library = "RoomManagement.js")
public final class RoomManagement{

  @Inject
  private JavaScriptSupport javascriptSupport;

  @Property
  private long contactId;

  @AfterRender
  private void setup() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("contactId", contactId);
    javascriptSupport.addInitializerCall("RoomManagement",jsonObject);
  }
}