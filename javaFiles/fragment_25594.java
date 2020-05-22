@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container.getClass().isAssignableFrom(UndertowEmbeddedServletContainerFactory.class)) {
                    UndertowEmbeddedServletContainerFactory undertowContainer = (UndertowEmbeddedServletContainerFactory) container;
                    undertowContainer.addDeploymentInfoCustomizers(new ContextSecurityCustomizer());
                }
            }
        };
    }

    private static class ContextSecurityCustomizer implements UndertowDeploymentInfoCustomizer {

        @Override
        public void customize(io.undertow.servlet.api.DeploymentInfo deploymentInfo) {
            SecurityConstraint constraint = new SecurityConstraint();
            WebResourceCollection traceWebresource = new WebResourceCollection();
            traceWebresource.addUrlPattern("/*");
            traceWebresource.addHttpMethod(HttpMethod.TRACE.toString());
            constraint.addWebResourceCollection(traceWebresource);
            deploymentInfo.addSecurityConstraint(constraint);
        }

    }