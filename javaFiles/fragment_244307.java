import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

AWSLambda client = AWSLambdaClientBuilder.standard().build();
InvokeRequest request = new InvokeRequest().withFunctionName("MyFunction").withInvocationType("RequestResponse").withLogType("Tail").withClientContext("MyApp")
        .withPayload(ByteBuffer.wrap("fileb://file-path/input.json".getBytes())).withQualifier("1");
InvokeResult response = client.invoke(request);