import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Test {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        new Test().execute();
    }

    public void execute() throws IOException{
        File dir = new File("test");
        dir.mkdirs();

        char[] data = new char[100];
        Arrays.fill(data, (char)'q');

        for(int x = 0; x < 1760; x++){
            File file = new File(dir, "file" + x);
            file.createNewFile();

            FileWriter fw = null;
            try{
                fw = new FileWriter(file);
                fw.write(data);
            }finally{
                if(fw != null){
                    fw.close();
                }
            }
        }

        delete(dir);

        //dir.mkdirs(); <-- commented out
        while(!dir.mkdirs()); //<-- dir.mkdirs() will return false until the directory has been successfully re-created

        new File(dir, "file").createNewFile();
    }

    private void delete (File f){
        if(f.isDirectory()){
            for(File afile : f.listFiles()){
                delete(afile);
            }
            f.delete();
        }else{
            f.delete();
        }
    }

}