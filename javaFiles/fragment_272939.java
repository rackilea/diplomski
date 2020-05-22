public abstract class FacadeBase<T extends FacadeException> {

    private Supplier<T> suppException;

    public FacadeBase(Supplier<T> suppException) {
        this.suppException = suppException;
    }

    public void checkFacadeAvailability(final String facadeId) throws T {
        if (!isFacadeAvailable(facadeId)) {
            throw suppException.get();
        }
    }
}