class Test{

  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 

  @Mock
  private FileWriterFactory fileWriterFactory;
  private Writer fileWriter = spy(new StringWriter());
  File anyValidFile = new File(".");
  @Test
  public void initIndexFile_validFile_addsEmptyraces(){
     //arrange
     doReturn(fileWriter).when(fileWriterFactory).create(any(File.class));

     // act
     new ClassUnderTest(fileWriterFactory).initIndexFile(anyValidFile);

     //assert
     verify(fileWriterFactory)create(anyValidFile);
     assertEquals("text written to File", "[]", fileWriter.toString());
     verify(fileWriter).close();
  }
}