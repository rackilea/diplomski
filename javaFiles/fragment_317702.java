@Autowired
private BeanFactory beanFactory;


@Override
public void run(String... args) throws Exception {
    Sprinter adam = beanFactory.getBean(Sprinter.class, "adam");
    TennisPlayer roger = beanFactory.getBean(TennisPlayer.class, "roger");

    executor.execute(adam);
    executor.execute(roger);
}