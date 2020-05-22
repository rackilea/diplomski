class ResourceNotFoundProxyPostProcessor implements RepositoryProxyPostProcessor {

    @Override
    public void postProcess(ProxyFactory factory, RepositoryInformation repositoryInformation) {
        if (repositoryInformation.getRepositoryInterface().equals(CityRepository.class))
            factory.addAdvice(new ResourceNotFoundMethodInterceptor());
    }

}