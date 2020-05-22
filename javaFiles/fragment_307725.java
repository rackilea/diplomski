/**Removes 'invalid' characters (&,#,@) from pathnames in the given folder, and subfolders, and returns the number of files renamed*/
public int renameDirectory(File base){
    //LinkedList<File> fileList = new LinkedList<File>();

    int count=0;//count the renamed files in this directory + its sub. You wanted to do this?

    //Process each file in this folder.
    for (File file: base.listFiles()){

        String origName = file.getName();
        File resultFile=file;

        if (origName.contains("&")  || origName.contains("#") || origName.contains("@")){
            //I would replace the if statement with origName.matches(".*[&#@].*") or similar, shorter but more error prone.
            System.out.println("Original name: "+origName);
            origName = origName.replaceAll("&", "_and_");
            origName = origName.replaceAll("@", "_at_");
            String newName = origName.replaceAll("#", "_");
            System.out.println("New Name: "+newName);
            String newLoc = baseLoc+File.separator+newName;//having "/" hardcoded is not cross-platform.
            File newFile = new File(newLoc);
            System.out.println(file.renameTo(newFile));
            count++;
            resultFile=newFile;//not sure if you could do file=newFile, tired
        }

        //if this 'file' in the base folder is a directory, process the directory 
        if(resultFile.isDirectory()){//or similar function
            count+=renameDirectory(resultFile);
        }
    }
    return count; 
}