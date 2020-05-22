public class Main {
    public static void main(String args[]) {

        Arrayable[] classArray = {
            new SubClass1(),
            new SubClass2()
        };

        Array2D<Arrayable> a2d = new Array2D<>(classArray);
        Arrayable[] array = a2d.returnSomething();
    }
}