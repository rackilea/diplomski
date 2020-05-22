public interface Processor<P extends Processor>
{
    Runner<P> getRunner();
}

public interface Runner<P extends Processor<P>>
{
    int runProcessors(Collection<P> processors);
}