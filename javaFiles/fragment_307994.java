@Resource
WebServiceContext wsctx;

@Override
public String callOperation() {

MessageContext mctx = wsctx.getMessageContext();

//get detail from request headers
    Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
    List userList = (List) http_headers.get("Username");
    List passList = (List) http_headers.get("Password");


    String username = "";
    String password = "";
    // do whatever you want with user and password