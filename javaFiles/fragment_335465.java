public class DefaultFocusBehavior extends AjaxEventBehavior {

public DefaultFocusBehavior(String event) {
    super(event);
}

private static final long serialVersionUID = 1;

private Component component;

@Override
protected void onEvent(AjaxRequestTarget target) {
    target.appendJavaScript(("document.getElementById('" + component.getMarkupId() + "').blur();"
            + "document.getElementById('" + component.getMarkupId() + "').focus();"));

}

protected void onBind() {
    this.component = getComponent();
    component.setOutputMarkupId(true);
}