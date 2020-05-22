@Service
public class SomeService  {

    @Autowired
    private MessageProcessorServiceFactory factory;

    public void doSomething(Message message) {
        String messageType = message.getType();//Type must be typeA or typeB, matching processor beans names

        MessageProcessorService messageProcessorService = factory.getMessageProcessorService(messageType);
        messageProcessorService.process(message);
    }
}