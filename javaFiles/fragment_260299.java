public class MyComponent {

    @Inject
    private Messages messages;

    @Property
    private String messageToDisplay;

    @SetupRender
    final void init() {
        // ...
        messageToDisplay = messages.get("some-key").format(valueForParam0, valueForParam1, ...);
        // ...
    }
}