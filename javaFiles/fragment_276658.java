MyClass myClass = ....

eventBroker.post("/list/updated", myClass);


@Inject
@Optional
public void listUpdated(@UIEventTopic("/list/updated") MyClass myClass)