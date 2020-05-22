add(new AjaxPagingNavigator("id", pageable){

    @Override
    protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
        AbstractLink link = newPagingNavigationLink(id, pageable, pageNumber); 
        link.add(new AjaxEventBehavior("click") {
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                target.appendJavaScript("$(\"html\").scrollTop(0);");
            }
        });

        return link;
    }

});