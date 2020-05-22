public class ExtendedA extends ClassA {

    private ExtendedA(int numberOfInstances) {

         super(numberOfInstances);
    }

    public static void main(String[] args) {

        ExtendedA ext = new ExtendedA(420);
        System.out.print(ext.numberOfInstances);
    }
}