public List<Component> getAllComponents(Container container) {
    Component[] components = container.getComponents();
    List <Component> result = new ArrayList<Component>();
    for (Component component : components) {
        result.add(component);
        if (component instanceof Container) {
            result.addAll(getAllComponents((Container) component));
        }
    }
    return result;
}