public class Main {

    @Autowired
    private CarDao carDao;

    public Main() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanInit.class);
        ctx.getAutowireCapableBeanFactory().autowireBean(this);
    }

    //psvm(){}

    public void runApp(){
        carDao.save(new Car());  //carDao is null
    }
}