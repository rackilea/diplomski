@Bean
public RequestContextFilter requestContextFilter() {
    OrderedRequestContextFilter filter = new OrderedRequestContextFilter();
    filter.setOrder(-100001);
    return filter;
}