@Override
public void beforePhase(PhaseEvent event) {
    applyLabels(event.getFacesContext().getViewRoot().getChildren());
}

private static void applyLabels(List<UIComponent> components) {
    for (UIComponent component : components) {
        if (component instanceof HtmlOutputLabel) {
            // ...
        } else {
            applyLabels(component.getChildren()); // Reapply on its children.
        }
    }
}