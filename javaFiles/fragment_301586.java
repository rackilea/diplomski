public class HibernateRxDao implements RxDao {
    ...

    public Rx getRxById(int rxId) {
        return sf.getCurrentSession().get(rxId, Rx.class);
    }

    public Map<String, List<Notification>> getAllRxNotificationsGroupedByFacility() {
        return toMap(sf.getCurrentSession().createNativeQuery(...). ... .list());
    }

    private Map<String, List<Notification>> toMap(List<Object[]> rows) { ... }
}