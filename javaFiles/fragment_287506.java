@PersistenceContext
private EntityManager em;

@Test
public void testCreateInvitation() {
    // create first invitation,
    // create second invitation
    em.flush();
}