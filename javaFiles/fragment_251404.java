public <T extends Component> T getComponent (Class<T> componentClass){
    for (Component c: this.components){ 
        //I know this doesn't work, I want to know how to check if the type
        //matches and return it (ie. Collider col = GetComponent<Collider>();)
        if(c.getClass().isAssignableFrom(componentClass)) {
            System.out.println("Component of type: " + c.getClass().getSimpleName() + " found!");
            return (T) c;
        }
    }
    System.out.println("No component found");
    return null;
}