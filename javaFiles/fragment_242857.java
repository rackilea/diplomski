private void createComponentMap() {
        componentMap = new HashMap<String,Component>();
        Component[] components = yourForm.getContentPane().getComponents();
        for (int i=0; i < components.length; i++) {
                componentMap.put(components[i].getName(), components[i]);
        }
}

public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
}