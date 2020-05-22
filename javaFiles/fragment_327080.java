/**
 * A special implementation of {@link SecurityManager}
 * that will throw a {@link TriedToExitException}
 * if {@link System#exit(int)} is called.
 * This is useful for testing main methods
 * without shutting
 * down the jvm running junit.
 * Tests can catch {@link TriedToExitException}
 * to figure out what exit code was set.
 */
public static final SecurityManager NON_EXITABLE_MANAGER = new SecurityManager(){

    @Override
    public void checkPermission(Permission perm) {
        //allow everything
    }
    /**
     * Throws a {@link TriedToExitException} instead of exiting.
     * <p/>
     * {@inheritDoc}
     */
    @Override
    public void checkExit(int status) {
        throw new TriedToExitException(status);
    }

};

public static final class TriedToExitException extends SecurityException{
    private static final long serialVersionUID = 1L;
    private final int exitCode;

    public TriedToExitException(int exitCode){
        this.exitCode=exitCode;
    }

    @Override
    public String getMessage() {
        return String.format("tried to System.exit(%d)",exitCode);
    }

    public int getExitCode() {
        return exitCode;
    }