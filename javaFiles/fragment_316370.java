private Map<String,EvenetCommand[]> eventMap;

@Inject
public Extractor(EventBus eventBus, Map<String,EventCommand[]> eventMap) {
    this.eventBus = eventBus;
    this.eventMap = eventMap;
}

private ExtractCommand[] getSystemSpecificExtractCommands() {
    String os = GetOsName();
    return eventMap.Get(os);
}

protected GetOsName();
{
    return System.getProperty("os.name");
}