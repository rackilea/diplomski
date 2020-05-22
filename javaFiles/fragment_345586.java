public class ArchiveRequestHandler implements RequestHandler<SNSEvent, Void> {

    @Override public Void handleRequest(SNSEvent input, Context context) {
        // do something with the message
        return null;
    }
}