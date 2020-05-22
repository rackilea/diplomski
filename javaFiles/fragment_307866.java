final ClientRequest request = new ClientRequest();
request.setMethod(new HttpString(requestMethod));
request.getRequestHeaders().put(Headers.TRANSFER_ENCODING, "chunked");
request.getRequestHeaders().put(Headers.COOKIE, "name=value; name2=value2; name3=value3");

connection.sendRequest(request, new ClientCallback<ClientExchange>() {
    @Override
    public void completed(ClientExchange clientExchange){}
    @Override
    public void failed(IOException e){}
}