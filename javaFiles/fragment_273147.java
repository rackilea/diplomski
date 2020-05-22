public class TESTER_API {

public static void TESTER_API_Connector(FXMLDocumentController controller) throws IOException, InterruptedException {
    [...]
    emissions.getEvents().getSomethingSpecific()
    .subscribe(event -> Platform.runLater(() -> {
        controller.updateTextArea(event.getSomethingSpecific());
    }),
    throwable -> new Exception("GUI error!"));

}