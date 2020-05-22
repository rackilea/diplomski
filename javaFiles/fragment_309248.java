@Configuration
public static class PersistenceConfiguration {

        @Bean
        @Primary
        public DataSource ds1() {
            return new EmbeddedDatabaseBuilder().build();
        }

        @Bean
        public DataSource ds2() {
            return new EmbeddedDatabaseBuilder().build();
        }

        @Bean
        @Primary
        @Autowired
        public LocalContainerEntityManagerFactoryBean emfb(@Qualifier("ds1") DataSource ds, EntityManagerFactoryBuilder emfb) {
            return emfb.dataSource(ds)
                    .packages(DemoApplication.class)
                    .persistenceUnit("ds1")
                    .build();
        }

        @Bean
        @Autowired
        public LocalContainerEntityManagerFactoryBean emfb2(@Qualifier("ds2") DataSource ds, EntityManagerFactoryBuilder emfb) {
            return emfb.dataSource(ds)
                    .packages(DemoApplication.class)
                    .persistenceUnit("ds2")
                    .build();
        }
 }