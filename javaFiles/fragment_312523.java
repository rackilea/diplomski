@Override
public Component getFirstComponent(Container aContainer) {
    System.out.println("first");
    return firstComponentInTab(0) ;//firstComponentInCurrentTab();
}

private Component firstComponentInCurrentTab() {
    int tabIndex = currentTab;
    return firstComponentInTab(tabIndex);
}

private Component firstComponentInTab(int tabIndex) {
    Component comp = container.getComponentAt(tabIndex);
    LOG.info("comp: " + comp.getName());
    if (comp instanceof Container) {
        Component[] components = ((Container) comp).getComponents();
        if (components.length == 0) {
            return null;
        }
        return components[0];
    } else {
        return comp;
    }
}