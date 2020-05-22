@IncludeJavaScriptLibrary("MyMixin.js")
public class MyMixin {

    /**
     * Some string param.
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String someParam;

    @Environmental
    private RenderSupport renderSupport;

    @InjectContainer
    private AbstractTextField field;

    @AfterRender
    void addScript() {
        this.renderSupport.addScript("new MyJavascriptClass('%s', '%s');", 
                this.field.getClientId(), this.someParam);
    }

}