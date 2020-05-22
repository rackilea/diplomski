import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    private    int i = 0;
    private    String userdate = "";
    private    Scanner scan = new Scanner (System.in);
    private    int day = scan.nextInt();
    private    int fday;
    private    ArrayList<String> dates = new ArrayList<String>();


    private void datesFinder(int fday) throws IOException, FileNotFoundException {
        Scanner fileScan = new Scanner(new File("cal.txt"));
        while (fileScan.hasNext()){
            String line = fileScan.nextLine();
            if (line.contains("DTSTART")){
                if (line.length()>25){
                    String year = line.substring(19,23);
                    String month = line.substring(23,25);
                    String dayofmonth = line.substring(25,27);
                    userdate = (dayofmonth + "/" + month + "/" + year);

                }
            }

            if (line.contains("SUMMARY")) {
                String summary = line.substring(12,13);
                if (summary.equals(fday)){
                    i = i+1;
                    dates.add(userdate);
                }
            }
        }//while
    }

    public String getDates(int fday){
        try {
            datesFinder(fday);
            for(int j = 0; j < dates.size(); j++) {
                String a = dates.get(j);
                return a;
            }
        }catch (IOException e){
          e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.getDates((int) (new Date().getTime()/1000));
    }
}