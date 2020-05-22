class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }
    public void roar() {
        System.out.println("Roar");
    }

    public void accept(AnimalVisitor av) {
        av.visit(this);                            // <-- Accept and call visit.
    }
}


class Deer extends Animal {

    public Deer(String name) {
        super(name);
    }

    public void runAway() {
        System.out.println("Running...");
    }

    public void accept(AnimalVisitor av) {
        av.visit(this);                            // <-- Accept and call visit.
    }

}