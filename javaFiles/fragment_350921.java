@Test
public void testEntityGetsPersisted() {
    int countBefore = getCurrentCountOfEntities();
    persistNewEntity();
    int countAfter = getCurrentCountOfEntities();
    assertTrue(countAfter == countBefore + 1);
}