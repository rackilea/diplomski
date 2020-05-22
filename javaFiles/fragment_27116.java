// Add this in Main class
private void button1Action() {
    FileChooser fc = new FileChooser();
    fc.setInitialDirectory(new File("C:\\Users"));
    List<File> selectedFiles = fc.showOpenMultipleDialog(null);
    if (selectedFiles != null) {
        for (int i = 0; i < selectedFiles.size(); i++) {
            lview.getItems().add(selectedFiles.get(i).getAbsolutePath());
        }
    } else {
        System.out.println("File is not Valid");
    }
}