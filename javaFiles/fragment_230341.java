@Before
public void setUp() {
    // Use a static import for Mockito.mock()
    this.documentConfig = mock(DocumentConfig.class);
    this.service = new DocumentService(this.documentConfig);
}

@Test
public void save_failure()  {
    // Use a static import for Mockito.when()
    when(this.documentConfig.isNameRequired()).thenReturn(true); 
    // TODO: Implement test
}