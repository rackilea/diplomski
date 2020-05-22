public abstract class Operation implements ... {
    private String filename;

    public Operation(String filename) { this.filename = filename; }

    public abstract void execute();
 }