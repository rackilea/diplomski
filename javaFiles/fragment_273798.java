listAssetFiles2(path); // <<-- Call function where required
//function to list files and directories
public void listAssetFiles2 (String path){
String [] list;

try {
    list = getAssets().list(path);
    if(list.length > 0){
        for(String file : list){
            System.out.println("File path = "+file);

            if(file.indexOf(".") < 0) { // <<-- check if filename has a . then it is a file - hopefully directory names dont have . 
                System.out.println("This is a folder = "+path+"/"+file);
                if(path.equals("")) {
                    listAssetFiles2(file); // <<-- To get subdirectory files and directories list and check 

                }else{
                    listAssetFiles2(path+"/"+file); // <<-- For Multiple level subdirectories
                }
            }else{
                System.out.println("This is a file = "+path+"/"+file);
            }
        }

    }else{
        System.out.println("Failed Path = "+path);
        System.out.println("Check path again.");
    }
}catch(IOException e){
    e.printStackTrace();
}