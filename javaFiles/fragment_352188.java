public class MyInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        ctx.getServletRegistration("default").addMapping("*.html");
        ctx.getServletRegistration("default").addMapping("/index.html");
    }
}