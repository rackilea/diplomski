@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @JsonView(View.Summary.class)
    @RequestMapping("/")
    public List<Message> getAllMessages() {
        return messageService.getAll();
    }

    @RequestMapping("/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageService.get(id);
    }
}