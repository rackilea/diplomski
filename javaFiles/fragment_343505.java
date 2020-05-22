public Restlet createInboundRoot() {
    Router router = new Router(getContext());
    router.attach("/countries/", Countries.class);
    router.attach("/countries/html/", CountryResource.class); 

    return router;
}