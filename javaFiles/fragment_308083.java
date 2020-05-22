String  saveToFolder = "kut igeiguye jh";
    String defaultFolder = "C:\\Parent\\Data";

    try{
        File file = new File(saveToFolder);
        boolean dirCreated = file.mkdirs();
        if(!dirCreated || (file.getParent().equals(null))){
            saveToFolder = defaultFolder;
        }
    }catch(Exception e){
        saveToFolder = defaultFolder;
    }

    System.out.println("save to folder : " +saveToFolder);