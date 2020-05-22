@Bean
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Lazy
public DataSourcePublicMetrics dataSourcePublicMetrics() {
    return new DataSourcePublicMetrics();
}