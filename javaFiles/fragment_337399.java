@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @JsonView(View.SummaryWithRecipients.class)
    @RequestMapping("/with-recipients")
    public List<Message> getAllMessagesWithRecipients() {
        return messageService.getAll();
    }
}