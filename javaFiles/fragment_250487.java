class OneService extends BaseWebService {

   Response process(HTTPRequest request) throws SDKException{
        return request.methodName();
   } 
}