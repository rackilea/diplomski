public class LambdaFunctionHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream output, Context context) throws IOException {
        byte serializedSpeechletRequest[] = IOUtils.toByteArray(inputStream);
        SpeechletRequestEnvelope requestEnvelope = SpeechletRequestEnvelope.fromJson(serializedSpeechletRequest);
        SpeechletRequest speechletRequest = requestEnvelope.getRequest();

        if (speechletRequest instanceof IntentRequest) {
            IntentRequest ir = (IntentRequest) speechletRequest;
            String outString = "IntentRequest name: " + ir.getIntent().getName();
            context.getLogger().log(outString);
            output.write(outString.getBytes());
        }
    }
}