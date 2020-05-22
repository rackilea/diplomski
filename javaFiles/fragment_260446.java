@Test @InSequence(0)
public void shouldCreateContentAndRevision() throws Exception {

    // create java objects, unmanaged:
    Content content = Content.create("My first test");

    assertNotNull("content should have current revision", content.getCurrent());
    assertSame("content should be same as revision's parent", content, content.getCurrent().getContent());
    assertEquals("content should have 1 revision", 1, content.getRevisionList().size());
    assertSame("the list should contain same reference", content.getCurrent(), content.getRevisionList().get(0));

    // persist the content, along with the revision:
    transaction.begin();
    entityManager.joinTransaction();
    entityManager.persist(content);
    transaction.commit();

    // verify:
    assertEquals("content should have ID 1", Long.valueOf(1), content.getId());
    assertEquals("content should have one revision", 1, content.getRevisionList().size());
    assertNotNull("content should have current revision", content.getCurrent());
    assertEquals("revision should have ID 1", Long.valueOf(1), content.getCurrent().getId());
    assertSame("current revision should be same reference", content.getCurrent(), content.getRevisionList().get(0));
}