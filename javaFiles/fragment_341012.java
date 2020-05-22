@Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void initIndexFile_missingFile_IndexFileInitializationException(){
     //arrange
     doReturnThrow(new IOException("UnitTest")).when(fileWriterFactory).create(any(File.class));

     //assert
     exception.expect(IndexFileInitializationException.class);
     exception.expectMessage("Error initialization index file "+anyValidFile.getPath());

     // act
     new ClassUnderTest(fileWriterFactory).initIndexFile(anyValidFile);
  }