@Bean
        @ConditionalOnExpression("#{environment.getProperty('security.oauth2.custom.filters').contains('XTokenFilter')}")
        public FilterRegistrationBean xxTokenFilter() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean();
            XTokenFilter xTokenFilter = new XTokenFilter();
            xTokenFilter.setAuthenticationManager(XOuthenticationManager());
            beanFactory.autowireBean(xTokenFilter );


    registrationBean.setFilter(xTokenFilter);
            registrationBean.setOrder(findOrderOfCustomFilters("XTokenFilter"));
            return registrationBean;
        }