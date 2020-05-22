private Session session;

@Before
public void setUpSession() throws Exception {
  session = sessionFactory.getCurrentSession();
}