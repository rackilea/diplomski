public class FooTransactionManager extends JpaTransactionManager {

    private Map<String, Integer> txTimeout = new HashMap<String, Integer>();

    public <T> void configureTxTimeout(Class<T> clazz, String methodName, Integer timeoutSecond) {
        txTimeout.put(clazz.getName() + "." + methodName, timeoutSecond);
    }

    //The timeout set by `configureTxTimeout` will have higher priority than the one set in @Transactional
    @Override
    protected int determineTimeout(TransactionDefinition definition) {;
        if (txTimeout.containsKey(definition.getName())) {
            return txTimeout.get(definition.getName());
        } else {
            return super.determineTimeout(definition);
        }
    }   
}