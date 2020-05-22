@Component
public class TxWorker {
    @Transactional
    public <T> T doInTx(Callable<T> callback) throws Exception {
        return callback.call();
    }
}