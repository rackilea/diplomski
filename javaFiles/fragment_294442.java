@Configuration
public class BeanConfig {
   @Autowired
   private LocalSessionFactoryBean sessionFactoryBean;

   @Bean(name="myBeanId")
   public MyBeanClass createMyBeanClass() {
      MyBeanClass mbc = new MyBeanClass();
      mbc.setSessionFactory((SessionFactory) sessionFactoryBean.getObject());
     ....
     return mbc;
   }
}