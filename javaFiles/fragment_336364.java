@Bean
public ProviderManager providerManager() {
    List<AuthenticationProvider> list = new ArrayList<AuthenticationProvider>();
    list.add(daoAuthenticationProvider());
    return new ProviderManager(list);
}

//If you use this filter (I think so, because you've defined 'username' and 'password' in
'configure' method)
@Bean
public UsernamePasswordAuthenticationFilter filter() {
    UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
    filter.setAuthenticationManager(providerManager());
    return filter;
}