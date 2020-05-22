class Test{       
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
  @Rule public ExpectedException exception = ExpectedException.none();

  @Mock
  private FileWriterFactory fileWriterFactory;
  @Mock
  private Writer failingFileWriter;
  private Writer validFileWriter = spy(new StringWriter());
  File anyValidFile = new File(".");
  @Test
  public void initIndexFile_validFile_addsEmptyraces(){
     //arrange         
     // act
     new ClassUnderTest(validFileWriter).initIndexFile();

     //assert
     verify(fileWriterFactory)create(anyValidFile);
     assertEquals("text written to File", "[]", fileWriter.toString());
     verify(fileWriter).close();
  }

  @Test
  public void initIndexFile_missingFile_IndexFileInitializationException(){
     //arrange
     doReturnThrow(new IOException("UnitTest")).when(failingFileWriter).write(anyString());

     //assert
     exception.expect(IndexFileInitializationException.class);
     exception.expectMessage("Error initialization index file "+anyValidFile.getPath());

     // act
     new ClassUnderTest(fileWriterFactory).initIndexFile(anyValidFile);
  }
}