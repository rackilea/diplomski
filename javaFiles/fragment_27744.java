@Inject
Conversation conversation;

@PostConstruct
public void init() {
    if(conversation.isTransient()) {
        conversation.end();
    }
    conversation.setTimeout(120000);
    conversation.start();
}