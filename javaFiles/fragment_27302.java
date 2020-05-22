public class SoapMvcConfiguration extends
            AbstractAnnotationConfigMessageDispatcherServletInitializer{

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class<?>[0];
        }

        @Override
        protected String getServletName() {
            return "soap";
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[] { SoapServiceConfiguration.class };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/ws/*" };
        }
    }

    public class RestMvcConfiguration extends
            AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class<?>[0];
        }

        @Override
        protected String getServletName() {
            return "rest";
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[] { RestConfiguration.class };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/api/*" };
        }

    }