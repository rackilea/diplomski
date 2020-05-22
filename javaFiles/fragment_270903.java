@Test
public void performsSaveAsWhenNetHasNoFile() {
    SaveAsAction saveAsAction = new SaveAsAction(null, null);
    FileDialog mockFileDialog = mock(FileDialog.class);
    Controller mockController = mock(Controller.class);
    Net mockNet = mock(Net.class);

    NetName normalName = new NormalNetName("");
    when(mockNet.getName()).thenReturn(normalName);

    File file = new File("test.xml");
    when(mockFileDialog.getFiles()).thenReturn(new File[]{file});

    // these steps are crucial
    saveAsAction.setFileDialog(mockFileDialog);
    saveAsAction.setController(mockController);

    // test
    saveAsAction.actionPerformed(null);

    verify(mockController).saveAsFile(file);
}