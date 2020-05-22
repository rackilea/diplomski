abstract class AbstractFlashyThing<F extends Flash> {

    List<F> flashes;

    AbstractFlashyThing() {
        flashes = new ArrayList<F>();
    }

    void doOperations() {
        for (F flash : flashes) {
            doOperation(flash);
        }
    }

    abstract void doOperation(F flash);

}