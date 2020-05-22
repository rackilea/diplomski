private RequestBody lastBody;

@Override
public Action<?> onRequest(Request request, Method actionMethod) {
    lastBody = request.body();
    return super.onRequest(request, actionMethod);
}

@Override
public Result onError(RequestHeader rh, Throwable t) {  
    //here i can get the body
    System.out.println(lastBody);

    return play.mvc.Results.internalServerError(errorPage.render());
}