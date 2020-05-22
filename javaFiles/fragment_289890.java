JFileChooser chooser = new JFileChooser();
    // Note: source for ExampleFileFilter can be found in FileChooserDemo,
    // under the demo/jfc directory in the Java 2 SDK, Standard Edition.

    String selectedFile = "The suggested save name.";
    chooser.setSelectedFile(selectedFile);

    ExampleFileFilter filter = new ExampleFileFilter();
    String extension = "Do something to find your extension";
    filter.addExtension(extension);
    filter.setDescription("JPG & GIF Images");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showSaveDialog(parent);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName());
       //then write your code to write to disk
    }