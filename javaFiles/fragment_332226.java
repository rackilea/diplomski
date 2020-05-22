public class MyClass {

    Map<String, String> selection;
    FileExtensionModel fem;

    MyClass() {
        selection = new HashMap<String, String>();
        selection.put("Text File", ".txt");
        selection.put("Rar File", ".rar");
        selection.put("Zip File", ".rar");
        selection.put("Tar File", ".tar");
        selection.put("Ini File", ".ini");
        fem = new FileExtensionModel(selection);
    }
}

private void openFilAction(ActionEvent e) {
    JFileChooser fc = new JFileChooser();

    fc.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(myFileType) || f.isDirectory();
        }

        public String getDescription() {
            for (String key : selection.keySet()) {
               if (selection.get(key).equals(myFileType)) {
                   return key;
               }
            }
            return "";
        }
    }

    int choose = fc.showOpenDialog(this);
    //do logic  
}