public class FirstClass {
    // Create the validator once per client instance, 
    // instead of once per method call
    private GlobalValidationClass fp = new GlobalValidationClass();

    public void firstPage() {
        fp.validatefields("first page");
    }

    public void secondPage() {
        sp.validatefields("second page");
    }