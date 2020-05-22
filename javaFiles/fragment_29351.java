public abstract class RootProcessor<T> {
    Class<T> clazz;
    { initClazz(); }

    @SuppressWarnings("unchecked")
    private void initClazz() {
        // the usual verbiage you already have in your question
        this.clazz = this.getClass().getGenericSuperclass().yadda().blah();
    }
}