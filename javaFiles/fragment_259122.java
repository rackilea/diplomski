@Bean
@ConditionalOnMissingBean({ RequestContextListener.class,
        RequestContextFilter.class })
public static RequestContextFilter requestContextFilter() {
    return new OrderedRequestContextFilter();
}