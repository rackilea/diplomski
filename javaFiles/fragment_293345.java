UICommandLink link = new UICommandLink(); // Note: you can also just use standard JSF HtmlCommandLink.
link.setId("linkId"); // Fixed ID is mandatory for successful processing.
link.setValue("click here"); // Not sure if you need it. Just to be complete.
AjaxBehavior ajaxAction = new AjaxBehavior();
ajaxAction.addAjaxBehaviorListener(new AjaxBehaviorListener() {
    @Override
    public void processAjaxBehavior(AjaxBehaviorEvent event) throws AbortProcessingException {
        System.out.println("Ajax behavior listener invoked."); // Do your actual job jere.
    }
});
link.addClientBehavior("action", ajaxAction); // Note: don't use "click" event!