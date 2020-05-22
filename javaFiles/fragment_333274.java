@Bean
public EmbeddedServletContainerCustomizer containerCustomizer() {

    return new EmbeddedServletContainerCustomizer() {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {

            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED,
                    "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,
                    "/404.html");
            ErrorPage error500Page = new ErrorPage(
                    HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            ErrorPage error505Page = new ErrorPage(
                    HttpStatus.HTTP_VERSION_NOT_SUPPORTED, "/505.html");
            ErrorPage error506Page = new ErrorPage(
                    HttpStatus.METHOD_NOT_ALLOWED, "/405.html");
            container.addErrorPages(error401Page, error404Page,
                    error500Page, error505Page, error506Page);
        }
    };
}