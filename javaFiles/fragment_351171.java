@SuppressWarnings("unchecked")
public class ClassC extends ClassB
{
    protected Object methodA(String lockName, TransactionCallback txCallback) {
        return super.methodA(lockName, txCallback);
    }
}