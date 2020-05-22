@Test @InSequence(4)
public void shouldChangeCurrentRevision2() throws Exception {
    transaction.begin();
    Document document = entityManager.find(Document.class, Long.valueOf(1));
    assertNotNull(document);
    assertEquals(1, document.getContentList().size());
    Content content = document.getContentList().get(0);
    assertNotNull(content);
    ContentRevision revision = content.getCurrent();
    assertNotNull(revision);
    assertEquals(2, content.getRevisionList().size());
    assertSame(revision, content.getRevisionList().get(1));
    transaction.commit();

    // load another instance, different from the one in the list:
    revision = entityManager.find(ContentRevision.class, revision.getId());
    revision.setTextData("CHANGED2");

    // start another TX, replace the "current revision" but not the one
    // in the list:
    transaction.begin();
    document.getContentList().get(0).setCurrent(revision);
    document = entityManager.merge(document); // here's your error!!!
    transaction.commit();

    content = document.getContentList().get(0);
    revision = content.getCurrent();
    assertSame(revision, content.getRevisionList().get(1));
    assertEquals("CHANGED2", revision.getTextData());
}