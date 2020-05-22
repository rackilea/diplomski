File fileObj;
String fileName, fileDir;

JFileChooser fileBrowser = new JFileChooser();
int result = fileBrowser.showOpenDialog(this);

if (result == JFileChooser.APPROVE_OPTION) {

   fileObj = fileBrowser.getSelectedFile();
   fileName = fileBrowser.getSelectedFile().getName();
   fileDir = fileBrowser.getCurrentDirectory().getAbsolutePath();

   // file may not exist
   if (!fileObj.exists()) {
     // show error msg
   }
}