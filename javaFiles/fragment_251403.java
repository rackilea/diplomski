public Component getComponent (){
    for (Component c: this.components){
        //I know this doesn't work, I want to know how to check if the type 
        //matches and return it (ie. Collider col = GetComponent<Collider>();)
        if(c instanceof Collider) {
            System.out.println("Component of type: " + c.name + " found!");
            return c;
        }
    }
    System.out.println("No component found");
    return null;
}