public class JerseyClientFilter extends ClientFilter {

    @Override
    public ClientResponse handle(ClientRequest request) {
        long startTime = System.currentTimeMillis();

        // execute call...
        ClientResponse response = getNext().handle(request);

        // build log...
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP:").append(response.getStatus());
        sb.append(" - Time:[").append(System.currentTimeMillis() - startTime).append("ms]");
        sb.append(" - User:").append(this.findLogon(request));
        sb.append(" - Path:").append(request.getURI());
        sb.append(" - Content-type:").append(request.getHeaders().get(HttpHeaders.CONTENT_TYPE));
        sb.append(" - Accept:").append(request.getHeaders().get(HttpHeaders.ACCEPT));
        sb.append(" - RequestBody:").append(request.getEntity() != null ? request.getEntity().toString() : "none");
        sb.append(" - ResponseBody:").append(this.logResponse(response));

        new TmaticwsInfoEvent(TmaticwsConstants.LOG_OUTBOUND_REST, this, request.getMethod(), sb.toString());
        return response;
    }