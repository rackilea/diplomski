//...
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:/foo/bar/persistence-mysql.properties"})
@ComponentScan({"foo.bar" })

        //...
               @Bean
               public AuditLogInterceptor auditLogInterceptor() {
                   return new AuditLogInterceptorImpl();
               }

               @Bean
               @Autowired
               public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
                  HibernateTransactionManager txManager = new HibernateTransactionManager();
                  txManager.setSessionFactory(sessionFactory);

                  txManager.setEntityInterceptor(auditLogInterceptor());
                  return txManager;
               }
        //...