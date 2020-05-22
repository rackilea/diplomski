private static Component findByName(Container root, String componentName) {
    int count = root.getComponentCount();
    for(int iter = 0 ; iter < count ; iter++) {
        Component c = root.getComponentAt(iter);
        String n = c.getName();
        if(n != null && n.equals(componentName)) {
            return c;
        }
        if(c instanceof Container) {
            c = findByName((Container)c, componentName);
            if(c != null) {
                return c;
            }
        }
    }
    return null;
}