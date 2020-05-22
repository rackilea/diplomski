@Autowired
private SimpMessagingTemplate template;


@RequestMapping(value = "/sendMessage")
public void sendMessage() throws Exception {
    this.template.convertAndSend("/topic/greetings", new HelloMessage(
            (int) Math.random(), "This is Send From Server"));
}