public interface ErrorHolder<T> {

    public void addError(T t);

    public int totalErrors();

    public boolean hasErrors();

    public void addWarning(T t);

    public int totalWarnings();

    public boolean hasWarnings();

    public List<T> getErrors();

    public List<T> getWarnings();
}