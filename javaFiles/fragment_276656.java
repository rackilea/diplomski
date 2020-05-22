@Inject
IEventBroker eventBroker;

...

eventBroker.post("/list/updated", Collections.EMPTY_MAP);