public class SetOnceHandler extends TagHandler
{
    private TagAttribute var;
    private TagAttribute value;

    public SetOnceHandler(TagConfig cfg) 
    {
        super(cfg);
        value = getRequiredAttribute("value");
        var = getRequiredAttribute("var");
    }

    public void apply(FaceletContext ctx, UIComponent parent) 
    {
        ctx.setAttribute(var.getValue(ctx), value.getObject(ctx));
    }
}