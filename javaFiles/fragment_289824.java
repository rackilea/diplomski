@RunWith(PowerMockRunner.class)
@PrepareForTest(DocumentService.class)
public class DocumentServiceTest {
@Test
public void should_set_id() throws Exception {
    final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
    UUID uuid = UUID.fromString(id);

    mockStatic(UUID.class);
    when(UUID.randomUUID()).thenReturn(uuid);

    DocumentService documentService = new DocumentService();

    JsonDocument document = new JsonDocument();
    documentService.saveDocument(document);

    assertThat(document.getId())
        .as("Id is set")
        .isEqualTo(id);
  }
}