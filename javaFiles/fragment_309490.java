public abstract class Wrapper {
    public void execute() { 
        try {
            // do some boiler plate before
            this.wrap();
            // do some boiler plate after.
        } catch (ExceptionA | ExceptionB ex)  {
            Type t = determineType(ex);
            throw new CustomException(t, ex);
        }
    }
    public void abstract wrap();
}