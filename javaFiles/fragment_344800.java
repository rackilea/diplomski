public class HandlerInterceptorTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    private @interface Custom {
    }

    private static class MyHandlerInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Custom annotation = handlerMethod.getMethodAnnotation(Custom.class);
                if (annotation != null) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class TestController {
        @Custom
        public void testMethodWithAnnotation() {}

        public void testMethodWithoutAnnotation() {}
    }

    @Test
    public void testMethodWithAnnotation() throws Exception {
        Method method = TestController.class.getMethod("testMethodWithAnnotation");
        TestController controller = new TestController();
        HandlerMethod handlerMethod = new HandlerMethod(controller, method);

        MyHandlerInterceptor interceptor = new MyHandlerInterceptor();
        boolean result = interceptor.preHandle(null, null, handlerMethod);

        assertTrue(result);
    }

    @Test
    public void testMethodWithoutAnnotation() throws Exception {
        Method method = TestController.class.getMethod("testMethodWithoutAnnotation");
        TestController controller = new TestController();
        HandlerMethod handlerMethod = new HandlerMethod(controller, method);

        MyHandlerInterceptor interceptor = new MyHandlerInterceptor();
        boolean result = interceptor.preHandle(null, null, handlerMethod);

        assertFalse(result);
    }
}