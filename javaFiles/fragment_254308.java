public class OrderResolver implements HandlerMethodArgumentResolver {


@Override
public boolean supportsParameter(MethodParameter methodParameter) {
    return methodParameter.getParameterType().equals(Order.class);
}

@Override
public Order resolveArgument(MethodParameter parameter,
                             ModelAndViewContainer mavContainer,
                             NativeWebRequest webRequest,       
                             WebDataBinderFactory binderFactory
                             ) throws Exception {

    Order order = new Order();

    Pattern pattern = Pattern.compile("product\\[(\\d+)\\]\\.type");

    for (String field : webRequest.getParameterMap().keySet()) {
        Matcher matcher = pattern.matcher(field);

        if (matcher.find()) {
            String type = webRequest.getParameter(field);

            Product product = null;

            switch (type) {
                case "typeA": product = new ProductTypeA(); break;
                case "typeB": product = new ProductTypeB(); break;
                case "typeC": product = new ProductTypeC(); break;
                default: continue;
            }

            product.setId(webRequest.getParameter("product[" + matcher.group(1) + "].id"));

            order.getProducts().add(product);
        }
    }       

    return order;

}