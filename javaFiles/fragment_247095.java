public class FileMain {

    static int i = 1;

    public static void main(String[] args) throws Exception {
        File file1 = new File("D:/workspace/dir");  
        renamefiles(file1);
    }

    private static void renamefiles(File file){

            File files[] = file.listFiles();
            for(File tempFile :files){

                if(tempFile.isDirectory()){
                    renamefiles(tempFile);
                }else{
                    System.out.println(tempFile.getName());

                    File renameFile = new File("sample-"+(++i)+".bck");
                    tempFile.renameTo(renameFile);

                }
            }



    }
}