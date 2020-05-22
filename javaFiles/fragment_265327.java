protected void init(WebConfig webConfig) throws ServletException {
    webComponent = (app == null)
            ? new InternalWebComponent()
            : new InternalWebComponent(app);
    webComponent.init(webConfig);
}