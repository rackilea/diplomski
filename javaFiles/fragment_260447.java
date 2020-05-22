@Test @InSequence(1)
public void shouldLoadContentAndRevision() throws Exception {
    Content content = entityManager.find(Content.class, Long.valueOf(1));
    assertNotNull("should have found content #1", content);

    // same checks as before:
    assertNotNull("content should have current revision", content.getCurrent());
    assertSame("content should be same as revision's parent", content, content.getCurrent().getContent());
    assertEquals("content should have 1 revision", 1, content.getRevisionList().size());
    assertSame("the list should contain same reference", content.getCurrent(), content.getRevisionList().get(0));
}