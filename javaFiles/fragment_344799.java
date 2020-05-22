class TestController {
    @Custom
    public void testMethod() {}
}

Method method = TestController.class.getMethod("testMethod");
TestController controller = new TestController();
HandlerMethod handlerMethod = new HandlerMethod(controller, method);

Custom annotation = handlerMethod.getMethodAnnotation(Custom.class);