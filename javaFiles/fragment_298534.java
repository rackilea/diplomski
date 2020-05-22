class CircleFactory extends ShapeFactory {
    public Circle newShape() {
       // your code from the source file
       return new Circle();
    }
    // javac generated method in the .class file
    public Shape newShape() {
       // call the other newShape method here -- invokevirtual newShape:()LCircle;
    }  
}