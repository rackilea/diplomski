public class TestClass6 {
        public static void main(String[] args)
    {
        String path = "c:/folder1/folder2";    // path of the folder you want to create
        File folder=new File(path);
        boolean exist=folder.exists();
        if(!exist){
            folder.mkdirs();
        }else{
            System.out.println("folder already exist");
        }
    }
}