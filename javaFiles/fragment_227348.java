public class Binder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(EventSchedudlerDaoImpl.class).to(EventSchedulerDao.class);
    }
}