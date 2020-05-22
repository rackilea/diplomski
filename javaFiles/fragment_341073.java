@Bean
         public ViewResolver viewResolver() {
             InternalResourceViewResolver resolver = new      InternalResourceViewResolver();
             resolver.setViewClass(JstlView.class);
            resolver.setPrefix("/");
            resolver.setSuffix(".jsp");
            return resolver;
     }