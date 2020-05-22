/**
 * Clears all the submitted values of input components in the same form as the specified component.
 * Call this method from action listener, e.g.
 * In Java bean:
 * {@code
 * public void processCloseAction(ActionEvent e) {
 *    clearSubmittedValues(e.getComponent());
 * }
 * }
 *
 * At page:
 * {@code
 * <a4j:commandButton actionListener="#{bean.processCloseAction}"
 *                    ajaxSingle="true"
 *                    limitToList="true"
 *                    oncomplete="Richfaces.hideModalPanel('#{id}')"
 *                    value="Cancel"/>
 * }
 *
 * @param component child of the form to be cleared
 */
public void clearSubmittedValues(UIComponent component) {
    while (component != null) {
        if (component instanceof UIForm || component instanceof UIAjaxRegion
                || component instanceof UIModalPanel) {
            clearRegion(component);
        }
        component = component.getParent();
    }
}

public void clearRegion(UIComponent parent) {
    for (UIComponent component : parent.getChildren()) {
        if (component instanceof EditableValueHolder) {
            EditableValueHolder input = ((EditableValueHolder) component);
            input.setSubmittedValue(null);
            // The following is only needed for immediate input components
            // but it won't do any harm in other situations..
            input.setValue(null);
            input.setLocalValueSet(false);
        } else {
            clearRegion(component);
        }
    }
}