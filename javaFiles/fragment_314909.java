@Controller
@EnableAutoConfiguration
@Configuration
public class HttpMethods extends WebMvcConfigurationSupport {

    public static class CopyMethodDispatcher extends DispatcherServlet {
        private static final long serialVersionUID = 1L;

        @Override
        protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
            if ("COPY".equals(request.getMethod())) {
                super.doPost(request, response);
            }
            else {
                super.service(request, response);
            }
        }
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(HttpMethods.class, args);
    }

    @RequestMapping("/method")
    @ResponseBody
    public String customMethod(final HttpServletRequest request) {
        return request.getMethod();
    }

    @Override
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        final RequestMappingHandlerAdapter requestMappingHandlerAdapter = super.requestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setSupportedMethods("COPY", "POST", "GET"); // add all methods your controllers need to support

        return requestMappingHandlerAdapter;
    }

    @Bean
    DispatcherServlet dispatcherServlet() {
        return new CopyMethodDispatcher();
    }
}