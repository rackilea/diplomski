import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainData {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        String line = "";
        String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/rj.csv"));
            Map<String, List<String>> questListByMinistry = new HashMap<>();
            Map<String, Integer> questCountByMinistry = new HashMap<>();
            //skip the first line (header)
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] rj = line.split(cvsSplitBy);

                if(!questCountByMinistry.containsKey(rj[2])){
                    //if the ministry doesn't exist as key yet put it to your map and put the value 1
                    questCountByMinistry.put(rj[2], 1);
                }
                else{
                    //else if it already exist get the current value and add +1
                    questCountByMinistry.put( rj[2], questCountByMinistry.get(rj[2])+1);
                }

                //-----------------------------------------------

                if(!questListByMinistry.containsKey(rj[2])){
                    //if key doesen't exist put it to map and create a new list                    
                    questListByMinistry.put(rj[2], new ArrayList<>());
                    // and add the question to the list
                    questListByMinistry.get(rj[2]).add(rj[3]);
                }
                else{
                    //else if key already exists get the list associated to key and add the question
                    questListByMinistry.get(rj[2]).add(rj[3]);
                }                
            }
            System.out.println(questCountByMinistry);
            System.out.println(questListByMinistry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}