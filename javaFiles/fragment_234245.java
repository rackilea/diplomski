@Override
protected TestContainerFactory getTestContainerFactory() {
    return new GrizzlyWebTestContainerFactory();
}

@Override
protected DeploymentContext configureDeployment() {
    ResourceConfig config = new ResourceConfig(SessionResource.class);
    return ServletDeploymentContext.forServlet(new ServletContainer(config))
                                   .addListener(AppContextListener.class)
                                   .build();
}