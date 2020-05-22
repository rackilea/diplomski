DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDirectory = directoryChooser.showDialog(stage);

if(selectedDirectory == null){
     //No Directory selected
}else{
     System.out.println(selectedDirectory.getAbsolutePath());
}