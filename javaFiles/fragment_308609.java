// new respose class, replace for your class - ResponseClass
public class Response {

    private int statusCode; // http status code

    private Map<String, String> headers; // headers

    private String body; // body - what you want to return to client

    public Response(int statusCode, Map<String, String> headers, String body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

/// -------------

package lambda;

    import com.amazonaws.services.lambda.runtime.Context;
    import com.amazonaws.services.lambda.runtime.RequestHandler;
    import lambda.axon.Path;

    public class shortestPath implements RequestHandler<RequestClass, Response>{

        public Response handleRequest(RequestClass request, Context context){
            String inputString = request.inputString;
            int steps = Path.stepsTo(inputString);

            Map<String, String> headers = new HashMap<>();
            headers.put(Access-Control-Allow-Origin, "*"); // cors header, you can add another header fields

            return new Response(200, headers, "" + steps);
            // return new Response(200, headers, "{result: " + steps + "}");
            // simple json response. ex: {result: '3433"}
        }
    }