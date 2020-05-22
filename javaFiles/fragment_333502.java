@Repository
public class HibernateStatsDao implements StatsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public GettingEventsStats getGettingEventStats(Integer eventId) {
        return sessionFactory.getCurrentSession().get(GettingEventsStats.class, eventId);
    }

    @Override
    public void createGettingEventCounter(Integer eventId) {
        GettingEventsStats gettingEventsStats = new GettingEventsStats();
        gettingEventsStats.setEventId(eventId);
        gettingEventsStats.setGettingCounter(1);
        sessionFactory.getCurrentSession().save(gettingEventsStats);
    }

    @Override
    public void updateGettingEventCounter(Integer eventId) {
        GettingEventsStats gettingEventStats = getGettingEventStats(eventId);
        gettingEventStats.setGettingCounter(gettingEventStats.getGettingCounter() + 1);
        sessionFactory.getCurrentSession().update(gettingEventStats);
    }
}