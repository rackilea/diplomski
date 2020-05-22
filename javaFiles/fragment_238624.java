@Inject
private Request request;

@OnEvent(EventConstants.SUCCESS)
Object formSubmitted(){
    //return zone content only if AJAX request, page otherwise
    if (request.isXHR()) {
        return myZone.getBody();
    } else {
        return this;
    }
}