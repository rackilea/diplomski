@Autowired
JpaVendorAdapter jpaVendorAdapter;

@Autowired
EntityManagerFactory entityManagerFactory;

void myMethod() {
    entityManagerFactory.getProperties()...
}