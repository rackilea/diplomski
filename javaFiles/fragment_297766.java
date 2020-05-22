Query query = session.createQuery("select u.subscriptions from User u where name = :name");  
query.setParameter("name", name);
List<EventHost> subscriptions = query.list();
List<Event> events = new ArrayList<Event>();
Query query2 = session.createQuery("select s.events from EventHost s where id = :id");  
for (EventHost s: subscriptions ) {
    query2.setParameter("id", s.getId());
    events.addAll( query2.list());
}