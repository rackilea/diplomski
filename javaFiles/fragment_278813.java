@Inject
IEventBroker eventBroker;

String value = .... value you want to send (doesn't have to be a string)

eventBroker.post("/my/topic", value);