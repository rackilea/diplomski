@Test @InSequence(3)
public void shouldChangeCurrentRevision() throws Exception {
    transaction.begin();
    entityManager.joinTransaction();
    Document document = entityManager.find(Document.class, Long.valueOf(1));
    assertNotNull(document);
    assertEquals(1, document.getContentList().size());
    Content content = document.getContentList().get(0);
    assertNotNull(content);
    ContentRevision revision = content.getCurrent();
    assertNotNull(revision);
    assertEquals(2, content.getRevisionList().size());
    assertSame(revision, content.getRevisionList().get(1));
    revision.setTextData("CHANGED");
    document = entityManager.merge(document);
    content = document.getContentList().get(0);
    revision = content.getCurrent();
    assertSame(revision, content.getRevisionList().get(1));
    assertEquals("CHANGED", revision.getTextData());
    transaction.commit();
}