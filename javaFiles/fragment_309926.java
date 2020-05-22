public TestCorsApplication() {
    CorsService corsService = new CorsService();
    corsService.setAllowedCredentials(true);
    corsService.setSkippingResourceForCorsOptions(true);

    getServices().add(corsService);
}