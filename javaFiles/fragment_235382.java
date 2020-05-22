import com.amazonaws.services.lambda.runtime.RequestStreamHandler

public class ChartHandler implements RequestStreamHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        DeserializationClass deserializedInput = objectMapper.readValue(inputStream, DeserializationClass.class)
        objectMapper.writeValue(outputStream, deserializedInput); //write to the outputStream what you want to return
    }

}