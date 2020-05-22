public class SSOAuthorizationResolver {

    public static class SSOAuthorizationInjectionResolver extends
            ParamInjectionResolver<SSOAuthorization> {
        public SSOAuthorizationInjectionResolver() {
            super(SSOAuthorizationValueFactoryProvider.class);
        }
    }


    @Singleton
    public static class SSOAuthorizationValueFactoryProvider extends
            AbstractValueFactoryProvider {

        @Context
        private HttpHeaders httpHeaders;

        @Inject
        public SSOAuthorizationValueFactoryProvider(
                final MultivaluedParameterExtractorProvider mpep,
                final ServiceLocator injector) {
            super(mpep, injector, Parameter.Source.UNKNOWN);
        }

        @Override
        protected Factory<?> createValueFactory(final Parameter parameter) {
            final Class<?> classType = parameter.getRawType();

            if (!Language.class.equals(classType)
                    || parameter.getAnnotation(SSOAuthorization.class) == null) {
                return null;
            }

            return new AbstractContainerRequestValueFactory<String>() {
                @Override
                public String provide() {
                    // Can use httpHeader to get your header here.
                    return httpHeader.getHeaderString("SSOAuthorization");
                }
            };
        }

    }

    // Binder implementation
    public static class Binder extends AbstractBinder {
        @Override
        protected void configure() {

            bind(SSOAuthorizationValueFactoryProvider.class).to(
                    ValueFactoryProvider.class).in(Singleton.class);

            bind(SSOAuthorizationInjectionResolver.class).to(
                    new TypeLiteral<InjectionResolver<SSOAuthorization>>() {
                    }).in(Singleton.class);

        }

    }
}