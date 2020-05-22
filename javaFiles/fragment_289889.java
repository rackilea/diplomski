JFileChooser chooser = new JFileChooser();
    // Note: source for ExampleFileFilter can be found in FileChooserDemo,
    // under the demo/jfc directory in the Java 2 SDK, Standard Edition.
    ExampleFileFilter filter = new ExampleFileFilter();
    filter.addExtension("jpg");
    filter.setDescription("JPG & GIF Images");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showSaveDialog(parent);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName());
    }