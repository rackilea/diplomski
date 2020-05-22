public class MyController
{
    @Autowired
    @Qualifier("normalBean")
    private MyBeanInterface base;

    @Autowired
    @Qualifier("specialBean")
    private MyBeanInterface special;
}