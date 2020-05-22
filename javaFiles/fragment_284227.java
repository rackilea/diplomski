@Configuration
public class ConfigClass
{
    @Bean(name="normalBean")
    @Primary
    public MyBeanInterface getNormalBeanInterface()
    {
        return new MyBeanInterfaceImpl();
    }

    @Bean(name="specialBean")
    public MyBeanInterface getSpecialBeanInterface()
    {
        return new MyBeanInterfaceForMyAnnotation();
    }
}