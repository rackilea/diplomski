public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
            FrontController.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/" 
        };
    }

}