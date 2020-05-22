public void doDeleteFile(ListView l, View v, int position, long id){
        File fileToDelete = new File(path.get(position));

        if(!fileToDelete.isDirectory()){

            try{
                if(fileToDelete.delete()){
                    System.out.println("File deleted successfull !");

                }else{
                    System.out.println("File delete operation failed");
                }
            }catch(Exception ex){
                System.out.println("Exception :"+ex.getMessage());
            }

        }else{

            System.out.println("It is  not a file");

        }