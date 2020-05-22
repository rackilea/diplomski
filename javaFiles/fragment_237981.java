@Test
public void testDateGenerationWhenInsertingEntityWithNullDate() {
    EntityWithGeneratedField e = new EntityWithGeneratedField();
    session.persist(e);
    session.flush();
    assertNotNull(e.getId());
    assertNotNull(e.getLastUpdDTTM());
}