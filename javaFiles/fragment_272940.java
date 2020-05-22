public class FacadeA extends FacadeBase<FacadeExceptionA>{

    public FacadeA(Supplier<FacadeExceptionA> suppException) {
        super(suppException);
    }   
}