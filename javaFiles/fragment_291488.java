private static final String FS = System.getProperty("file.separator");
JFileChooser folderChooser = new JFileChooser();
if (folderChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
    String filename = folderChooser.getSelectedFile().getPath();
    String[] recursivePaths = filename.split(FS);
    String first = recursivePaths[0];
    String last = recursivePaths[recursivePaths.length - 1];

    Arrays.stream(recursivePaths, 1, recursivePaths.length - 1).forEach( x -> {
       //stream the elements in the middle
    });
  });
}