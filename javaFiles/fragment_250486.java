abstract class BaseWebService {
   public abstract Response process(HTTPRequest request) throws SDKException;

   public Response webserviceCall(Request request) {

       HTTPRequest httpRequest = new HTTPRequest(new ConnectionProperties());

       String errorMessage = "";
       String errorCode = "";

       try {
           process(httpRequest);
       } catch (SDKException e) {
           errorMessage = e.getMessage();
           errorCode = e.getErrorCode();
       }

       Error error = new Error(errorMessage,errorCode);

       return new Response(error);
   }
 }