public class FileCopy implements Runnable {

    private String src="", dest = "";
    public FileCopy(String src, String dest){
        this.src  = src;
        this.dest = dest;
    }

    @override
    public void run(){
        File srcFolder = new File(src);
        File destFolder = new File(dest);

        if(!srcFolder.exists()){
           System.out.println("Directory does not exist.");
           //System.exit(0);
        }else{
           try{
            copyFolder(srcFolder,destFolder);
           }catch(IOException e){
            e.printStackTrace();
            //System.exit(0);
           }
        }
        System.out.println("Done"); 
    }//run
}