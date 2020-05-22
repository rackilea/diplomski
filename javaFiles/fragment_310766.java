@Import(library = {"Slidout.js"})
public class Slideout {

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Parameter(name="header", defaultPrefix = BindingConstants.LITERAL)
    private Block headerBlock;

    @Property
    @Parameter(value = "prop:componentResources.id", defaultPrefix = "literal")
    private String clientId;

    @AfterRender
    private void afterRender() {
        JSONObject props = new JSONObject();
        props.put("clientId", clientId);
        javaScriptSupport.addInitializerCall("Slideout", props);
    }

    public Block getHeader() 
    {
        return headerBlock;
    }
}