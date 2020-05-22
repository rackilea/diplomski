@RestController
@EnableAutoConfiguration
public class App {

    @RequestMapping("/")
    public String index() {
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static class MyException extends RuntimeException {

    }

    @Bean
    @Autowired
    public MappedInterceptor getMappedInterceptor(MyHandlerInterceptor myHandlerInterceptor) {
        return new MappedInterceptor(new String[] { "/" }, myHandlerInterceptor);
    }

    @Component
    public static class TestBean {
        public boolean judgeToken(HttpServletRequest request) {
            String token = request.getParameter("token");
            if (token == null) {
                throw new MyException();
            }
            return true;
        }
    }

    @Component
    public static class MyHandlerInterceptor implements HandlerInterceptor {

        @Autowired
        TestBean testBean;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            return testBean.judgeToken(request);
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                Exception ex) throws Exception {

        }
    }

    @ControllerAdvice
    public static class MyExceptionHandler {
        @ExceptionHandler(MyException.class)
        @ResponseBody
        public Map<String, Object> handelr() {
            Map<String, Object> m1 = new HashMap<String, Object>();
            m1.put("status", "error");
            m1.put("message", "Sorry, your provided token information expired or not exists.");
            return m1;
        }
    }

}