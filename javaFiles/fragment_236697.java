final File expectedFile = new File("abc");

    new MockUp<FileChooser>() {

        @Mock
        File showOpenDialog(final Window overWindow) {
            return expectedFile;
        }
    };

    final File actualFile = MyClass.OpenFile(...);

    assertEquals(expectedFile, actualFile);