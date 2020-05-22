public class RequestStageMarshaller implements DynamoDBMarshaller<RequestStage> {

        @Override
        public String marshall(RequestStage requestStage) {
            return requestStage.toString();
        }

        @Override
        public RequestStage unmarshall(Class<RequestStage> clazz, String 
requestStage) {
            return RequestStage.valueOf(requestStage);
        }

    }