public class Subclass extends Superclass {    
    // overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();//just do override
    }
    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();    
    }
}