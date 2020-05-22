public class CoreClass implements APIInterface {
    // is set via Builder
    private Optional optional = null; 

    public void coreMethod() {
        // implementation
    }

    public void optionalMethod() {
        if(optional != null) {
            optional.optionalMethod();
        }
    }
}