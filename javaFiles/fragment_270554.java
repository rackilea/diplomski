File[] files = new File("//sdcard//").listFiles();
String fileNames = "";
for(File f:files){
    fileNames += f.getName() + " - ";
}
textEdit.setText(fileNames);