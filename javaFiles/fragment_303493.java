@Stateless
@Local(SampleSqlSessionFactoryProvider.class)
public class SampleSqlSessionFactoryProvider {
    @Produces
    @ApplicationScoped
    @Named("sqlSessionFactory")
    public SqlSessionFactory produceFactory() throws Exception {        
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = null;
        String environment = "default";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, environment);
        return sqlSessionFactory;
    }
}