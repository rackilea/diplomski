String fileName = "foo";
FileUploader fileUploader = mock(FileUploader.class);

MainClass classUnderTest = new MainClass(fileUploader);
classUnderTest.startProcess();

verify(fileUploader, times(1)).uploadFile(fileName);