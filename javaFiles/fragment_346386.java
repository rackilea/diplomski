JFileChooser chooser;
if(pref.get("LAST_PATH", "") != null){
    // set last SELECTED file/directory path.
    chooser = new JFileChooser(pref.get("LAST_PATH", ""));
 } else{
     // set currentDirectory,  but dont select anything yet.
     chooser = new JFileChooser();
     chooser.setCurrentDirectory(new File(home_dir));
}