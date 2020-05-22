@Test
public void getPersonListByOtdelIdTest() {
  Long otdelId = 454L; // or = Long.valueOf(454); don't use new Long
  SessionFactory mockedSessionFactory = mock(SessionFactory.class);
  Session session = mock(Session.class);
  Query query = mock(Query.class);

  when(mockedSessionFactory.getCurrentSession()).thenReturn(session);
  when(session.createQuery("FROM Person P where P.otdel.otdelId = :otdelId"))
      .thenReturn(query);
  when(query.setParameter("otdelId", otdelId)).thenReturn(query);
  when(query.list()).thenReturn(persons);

  PersonDAOImpl personDAO = new PersonDAOImpl(mockedSessionFactory);
  List<Person> result = personDAO.getPersonListByOtdelId(otdelId);

  verify(query).setParameter("otdelId", otdelId);
  assertEquals(result, persons);
}