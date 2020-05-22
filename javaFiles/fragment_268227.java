@Configuration
public MyBeanFactory {
   @Bean
   public MyBeanInterface bean1() {
       return ...;
   }

   @Bean
   public MyBeanInterface bean2() {
       return ...;
   }
}

@Component
public MyBeanuser {

  @Autowired
  private MyBeanFactory beanFactory;

  @PostConstruct
  public void afterPropertiesSet() {
     // this will actually set the bean that was created an registered in the
     // spring context and not simply call the the method and create a new
     // instance. So  this wiring is very explicitly
     setProperty1(beanFactory.bean1());
     setProperty2(beanFactory.bean2());
 }