public class DocumentsRegistry {
    private Map<String, RecordingDocument> registry = new HashMap<String, RecordingDocument>();
    private static DocumentRegistry instace = new DocumentRegistry();

    public static DocumentRegistry getInstance() {
        return instance;
    }

    public void registerDocument(String key, RecordingDocument document) {
        registry.put(key, document);
    }

    public RecordingDocument getDocument(String key) {
        return registry.get(key);
    }
} 

// your handler

public static final String DOCUMENT_KEY = "DOCUMENT";

public Object execute(ExecutionEvent event) throws ExecutionException {
    IHandlerService service;
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    try {
        RecordingDocument d = new RecordingDocument("TestProject", "Tester", true);
        d.record();
        MessageDialog.openInformation(
                window.getShell(),
                "JavaTV",
                "You are now recording.");
        DocumentsRegistry.getInstance().registerDocument(DOCUMENT_KEY, d);
    } catch (CoreException e) {
        e.printStackTrace();
    }
    return null;
}

// another handler
 public Object execute(ExecutionEvent event) throws ExecutionException {
    RecordingDocument d = DocumentsRegistry.getInstance().getDocument(DOCUMENT_KEY);
    // do something with it
    return null;
}