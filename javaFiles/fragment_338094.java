public void delete(Schedule sched) 
        throws DataAccessException{
    //grab the events
    Collection<Event> events = sched.getEvents();
    //clear the collection
    events.clear();
    //flush the buffers
    getHibernateTemplate().flush();
    //reload
    sched = retrieve(sched);
    //delete the schedule
    super.delete(sched);
}