@Configuration 
public class AppConfig { 
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean() { ... }

    // FactoryBean is hidden behind this method
    public SqlSessionFactory sqlSessionFactory() {
        try {
            return sqlSessionFactoryBean().getObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    public AnotherBean anotherBean() {
        return new AnotherBean(sqlSessionFactory());
    }
}