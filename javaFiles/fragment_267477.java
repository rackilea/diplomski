public class MyBeanProcessor<T> extends AbstractRowProcessor{
    //here's the wrapped bean processor.
    private final BeanListProcessor<T> processor;

    //we need a LinkedHashMap here to keep the the correct ordering.
    private final LinkedHashMap<String, Integer> headersToCapture;

    public MyBeanProcessor(Class<T> beanType, LinkedHashMap<String, Integer> headersToCapture){
        processor = new BeanListProcessor<T>(beanType);
        this.headersToCapture = headersToCapture;
    }

    // work with parsed headers to find out what is in the input
    @Override
    public void rowProcessed(String[] inputRow, ParsingContext context) {
        //... more details later
    }

    @Override
    public void processEnded(ParsingContext context) {
        processor.processEnded(context);
    }

    public List<T> getBeans(){
        return processor.getBeans();
    }
}