class RadialTyre extends Tyre {
    // This is an overLOAD, same method name but different parameter type
    public void front(long a) {
        System.out.println("Radial Tire with int");
    }

    // This is an overRIDE, same method name with same signature
    public void front(int a) {
        System.out.println("Radial Tire with long - override");
    }
}