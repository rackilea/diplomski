@Inject
private ComponentResources resources;

@SetupRender //or any other lifecycle event method
private void triggerEvent() {
    Object yourVariable = new Object();
    resources.triggerEvent("YOUR_EVENT_NAME", new Object[]{yourVariable}, null);
    //add an event callback if needed where I use null here
}