public class OpenWindowOnLoadBehavior extends AbstractDefaultAjaxBehavior {
    @Override
    protected void respond(AjaxRequestTarget target) {
        ModalWindow window = (ModalWindow) getComponent();
        window.show(target);
    }
    @Override
    public void renderHead(IHeaderResponse response) {
        response.renderOnLoadJavascript(getCallbackScript().toString());
    }
}