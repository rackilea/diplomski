public class ClassThatOperates {
    Supplier<Integer> generator;

    public ClassThatOperates(Supplier<Integer> generator) {
        this.generator = generator;
    }

    public void doSomeOperation(){
        System.out.print("The number with constant is: ");
        System.out.println(generator.get() + 5);
    }
}