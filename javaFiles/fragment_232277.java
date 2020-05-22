public void setViewData(viewDataFromClient) {
    getThreadLocalRequest().getSession(true).setAttribute("key-goes-here", new ViewData());

    //...

public ViewData getViewData() {
    return (ViewData) getThreadLocalRequest().getSession().getAttribute("key-goes-here");
}