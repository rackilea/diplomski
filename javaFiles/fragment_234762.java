public ActionImpl implements Action {
    public Response get(Request request) {
        Response response = request.newResponse(OK);
        response.getOutputStream().write("body");
        return response;
    }
}