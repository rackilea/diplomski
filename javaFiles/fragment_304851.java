@WebListener
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        JspFactory.getDefaultFactory().getJspApplicationContext(event.getServletContext()).addELContextListener(new ELContextListener() {
            @Override
            public void contextCreated(ELContextEvent event) {
                event.getELContext().getImportHandler().importClass(MyEnum.class.getName());
            }
        });
    }

    // ...
}