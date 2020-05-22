public class AtomicReferenceChange {

    public static Object myReference = new Object();

    public static void changeObject(Object newObject) {
        myReference = newObject;
    }

    public static void main(String[] args) {

        System.out.println(AtomicReferenceChange.myReference);
        AtomicReferenceChange.changeObject("333");
        System.out.println(AtomicReferenceChange.myReference);

    }

}