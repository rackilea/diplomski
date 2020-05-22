@Service
public class MessageSender {

    private JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendUserConfirmationEmail(NewUserMessage message){
        jmsTemplate.convertAndSend(message);
    }
}