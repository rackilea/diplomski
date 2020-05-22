@ControllerAdvice(annotations = RestController.class)
public class MyRequestBodyAdvisor extends RequestBodyAdviceAdapter {
  @Override
  public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
    return methodParameter.getParameterType() == MyBean.class;
  }

  @Override
  public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
    MyBean myBean = (MyBean)body;
    List<String> strings = inputMessage.getHeaders().get("X-Property");
    myBean.setProperty(strings.get(0));
    return myBean;
  }
}