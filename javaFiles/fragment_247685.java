@ComponentScan(basePackages = "com.example.project",
         excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = {AnyCustomConnectionProvider.class, AnyCustomJpaConfiguration.class}))
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
                                    DataSourceTransactionManagerAutoConfiguration.class,
                                    HibernateJpaAutoConfiguration.class})