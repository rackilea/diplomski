import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.faces.RewriteViewHandler;

public class CustomRewriteViewHandler extends RewriteViewHandler {
    public CustomRewriteViewHandler(ViewHandler viewHandler) {
        super(viewHandler);
    }

    @Override
    public String getWebsocketURL(FacesContext context, String channel) {
        return super.parent.getWebsocketURL(context, channel);
    }
}