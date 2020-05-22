public class IOExceptionUnchecked extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public IOExceptionUnchecked(IOException e) {
        super(e);
    }
}