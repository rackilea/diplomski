public class MyTask extends SourceTask {

    @Autowired
    private SomeScopedBeanFactoryConfiguration  someScopedBeanFactoryConfiguration;

    @Override
    public void start(Map<String, String> props) {
        SomeScopedBean scopedBean = someScopedBeanFactoryConfiguration.create(props);    
    }
}