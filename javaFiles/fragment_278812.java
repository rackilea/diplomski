@Autowired
public MyService(AutowireCapableBeanFactory factory, TaskScheduler scheduler) {
    MyFirstCommand command1 = factory.getBean(MyFirstCommand.class);
    MySecondCommand command2 = factory.getBean(MySecondCommand.class);

    scheduler.schedule(command2, new Date());
    scheduler.schedule(command1, new Date());
}