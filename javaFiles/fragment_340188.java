class Person{
    Person parent; // <---- this is the "this.parent" attribute, and is initially undefined
    public void setParent(Person parent){ // <---- the "Person parent" on this line is an incoming parameter
        this.parent = parent; //<---- "this.parent" refers to the attribute, and "parent" refers to the parameter
    }
}