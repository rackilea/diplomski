public class SomeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        // ...
        return true;
    }
}

@Configuration
@ComponentScan("com.example")
@EnableWebMvc  
public class AppConfig extends WebMvcConfigurerAdapter  {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
          .addInterceptor(new SomeInterceptor())
          .addPathPatterns("/test/*");
    }
}

public class WebAppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {  
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(AppConfig.class);  
        ctx.setServletContext(servletContext);    
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        dynamic.addMapping("/");  
        dynamic.setLoadOnStartup(1);  
   }  
}