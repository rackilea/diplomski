@Autowired
private DefaultTokenServices tokenServices;

@Override
public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenServices(tokenServices);
}