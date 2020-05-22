public class MultipartRequest extends Request<String>{

   ...
   private final Map<String, String> mHeaders;
   ...

    public MultipartRequest(..., Map<String, String> headers, ...) {
        super(...);
        ...
        this.mHeaders = headers;
        ...
    }

   @Override
   public Map<String, String> getHeaders() throws AuthFailureError {
       return (mHeaders != null) ? mHeaders : super.getHeaders();
   }

   ...
}