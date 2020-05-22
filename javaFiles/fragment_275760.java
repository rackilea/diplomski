@Component
public class MessageServiceHelper {
    private final MessageService messageService;

    @Autowired
    public MessageServiceHelper(@Qualifier("emailService") MessageService messageService) {
        this.messageService=messageService;
    }

    public boolean sendMessage(String message){
        return this.messageService.sendMessage(message);
    }
}