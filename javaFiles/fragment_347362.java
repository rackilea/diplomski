package helloworld;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by matt on 07/02/2017.
 */
public class IndexedFileAccess {
    static String getKey(String line){
        return line.split(":")[0];
    }
    public static void main(String[] args) throws IOException {
        Map<String, Long> index = new HashMap<>();
        RandomAccessFile file = new RandomAccessFile("junk.txt", "r");
        //populate index and read file.
        String s;
        do{
            long start = file.getFilePointer();
            s = file.readLine();
            if(s!=null){
                String key = getKey(s);
                index.put(key, start);
            }
        }while(s!=null);

        for(String key: index.keySet()){
            System.out.printf("key %s has a pos of %s\n", key, index.get(key));
            file.seek(index.get(key));
            System.out.println(file.readLine());
        }
        file.close();

    }
}