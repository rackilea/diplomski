@Test(expected = Exception.class)
public void should_fail_when_file1_is_bigger_than_file2() {
  FileBuilder mockFile1 = file(2L);
  FileBuilder mockFile2 = file(1L);
  FileBuilder mockFileBuilder = mock(FileBuilder.class);
  when(mockFileBuilder.newFile("file1").thenReturn(mockFile1);
  when(mockFileBuilder.newFile("file2").thenReturn(mockFile2);

  new MyClass(mockFileBuilder).myMethodSpaceCheck();
}

private static File file(long length) {
    File mockFile = mock(File.class);
    when(mockFile.length()).thenReturn(length);
    return mockFile;
}