public ConferenceRoom getNewConferenceRoom(Person p) {
    ConferenceRoom r = new ConferenceRoom();
    r.setCode("MyUniqueGeneratedCode");
    r.getPeople().add(p);
    // sessionFactory is spring injected member
    sessionFactory.getCurrentSession().persist(r); 
}