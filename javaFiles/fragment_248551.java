public class ComputeEngine implements Compute {

private GlobalContext globalContext = //...

public <T> T executeTask(Task<T> t) {
    return t.execute(globalContext);
}