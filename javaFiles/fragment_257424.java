public class RequiredStarBevaviour extends AbstractBehavior {

@Override
public void beforeRender(final Component component) {
    super.beforeRender(component);
    if (component instanceof FormComponent<?>) {
        if (!((FormComponent<?>) component).checkRequired()) {
            component.getResponse()
                    .write("<span class='redclass'>*</span>");
        }
    }
}