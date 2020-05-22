@Test
public void testExtractAllDeflateAndNoEncryptionExtractsSuccessfully() throws IOException {
    ZipFile zipFile = new ZipFile(generatedZipFile);

     List<File> toAdd = Arrays.asList(
            getTestFileFromResources("sample_text1.txt"),
            getTestFileFromResources("sample_text_large.txt"),
            getTestFileFromResources("OrccTutorial.pdf"),
             getTestFileFromResources("introduction-to-automata-theory.pdf"),
             getTestFileFromResources("thomas.pdf")
    );
    zipFile.addFiles(toAdd);

    zipFile.setRunInThread(true);

    zipFile.extractAll(outputFolder.getPath());

    ProgressMonitor mon = zipFile.getProgressMonitor();
    while (mon.getState() == BUSY) {
        System.out.println(zipFile.getProgressMonitor().getPercentDone());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    ZipFileVerifier.verifyFolderContentsSameAsSourceFiles(outputFolder);
    verifyNumberOfFilesInOutputFolder(outputFolder, 5);
}