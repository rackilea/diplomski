package com.examples;
@Component
@Scope(value="request")
public class MyBean {
    @Autowired
    private MySpringBeanClass mySpringBean;
}