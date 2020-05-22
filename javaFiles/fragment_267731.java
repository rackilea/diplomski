@Bean(name="mybatis")
public MyBatisComponent myBatisComponent( SqlSessionFactory sqlSessionFactory )
{
    MyBatisComponent result = new MyBatisComponent();
    result.setSqlSessionFactory( sqlSessionFactory );
    return result;
}