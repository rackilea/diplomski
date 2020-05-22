package com.application.config;
// [imports]
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.application.controller", useDefaultFilters = false, includeFilters = @ComponentScan
        .Filter(Controller.class))
public class MyAppDispatcherServletContext