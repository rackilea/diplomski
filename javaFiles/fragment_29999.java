abstract class Client<T extends Client<T>> {
    List<Processor<T>> processors;

    public void doSmth(Message message) {
        for (Processor<T> processor : processors) {
            processor.doJob(getThis(), message);  
        }
    }

    abstract T getThis();

    public void registerListeners(Processor<T> subscribers) {
        this.processors = Arrays.asList(subscribers);
    }
}