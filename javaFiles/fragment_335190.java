class Rectangle implements GameObject {
    public void accept(Visitor visitor) {
        visitor.resolve(this);
        // Rectangle and its subclasses will call resolve(Rectangle)
        // whereas all other GameObjects will call resolve(GameObject)
        // though other GameObjects will need their own accept method
    }
}