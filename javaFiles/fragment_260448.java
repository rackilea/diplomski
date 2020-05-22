@Test @InSequence(2)
public void shouldAddAnotherRevision() throws Exception {
    transaction.begin();
    entityManager.joinTransaction();
    Content content = entityManager.find(Content.class, Long.valueOf(1));
    ContentRevision revision = content.addRevision("My second revision");
    entityManager.persist(revision);
    content.setCurrent(revision);
    transaction.commit();

    // re-load and validate:
    content = entityManager.find(Content.class, Long.valueOf(1));

    // same checks as before:
    assertNotNull("content should have current revision", content.getCurrent());
    assertSame("content should be same as revision's parent", content, content.getCurrent().getContent());
    assertEquals("content should have 2 revisions", 2, content.getRevisionList().size());
    assertSame("the list should contain same reference", content.getCurrent(), content.getRevisionList().get(1));
}