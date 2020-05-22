public abstract class AbstractTest implements InitializingBean{
    @Autowired
    private SessionFactory sf;

    //@BeforeClass
    @Override
    public void afterPropertiesSet() throws Exception {
        sf.getCurrentSession().createQuery("make tables");
}