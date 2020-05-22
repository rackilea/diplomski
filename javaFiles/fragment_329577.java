import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadingFile {
    public static String input_path = ("D:\\Aritra\\inputs");
    public static String output_path = ("D:\\Aritra\\outputs");
    static BufferedReader br;

    void read() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm.ss");
        SimpleDateFormat parsingSdf = new SimpleDateFormat("hh:mm.ss a");
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        try {
            File fi = new File(input_path);
            File[] fileCount = fi.listFiles();
            for (int i = 0; i < fileCount.length; i++) {
                File file = fileCount[i];
                if (file.isFile()) {
                    System.out.println("Total file count : " + fileCount.length);
                    String fileName = file.getName();
                    System.out.println("File name : " + fileName);
                    String data;
                    br = new BufferedReader(new FileReader(input_path + "\\" + fileName));
                    while ((data = br.readLine()) != null) {
                        if (data.contains(">")) {
                            Object[] received = new Object[3];
                            String dat = data.substring(data.indexOf(" ") + 1, data.indexOf("-") - 1);
                            // System.out.println(dat);
                            Date date = sdf.parse(dat.substring(dat.indexOf(" "), dat.lastIndexOf(".")));
                            // System.out.println(date);
                            String timeFormat = parsingSdf.format(date);
                            // System.out.println(timeFormat);
                            received[0] = dat.substring(dat.indexOf("0"), dat.indexOf(" ") + 1) + timeFormat;
                            // System.out.println(received[0]);
                            received[1] = data.substring(data.indexOf("<") + 1, data.indexOf(",") - 1);
                            // System.out.println(received[1]);
                            received[2] = data.substring(data.indexOf("Target"), data.lastIndexOf("."));
                            // System.out.println(received[2]);
                            //list.add(received);
                            boolean isAdded = false;

                            if (!list.isEmpty()) {
                                Date currentEntry = new SimpleDateFormat("dd/MM/yyyy hh:mm.ss a")
                                        .parse((String) received[0]);
                                int count = 0;
                                do {
                                    Object[] loopElement =  list.get(count);
                                    Date loopElementDate = new SimpleDateFormat("dd/MM/yyyy hh:mm.ss a")
                                            .parse((String) loopElement[0]);
                                    int compareResult = currentEntry.compareTo(loopElementDate);
                                    if(compareResult<=0) {
                                        list.add(count,received);
                                        isAdded = true;
                                        break;
                                    } 
                                    count++;
                                } while (count < list.size());

                            }
                            if(!isAdded) {
                                list.add(received);
                            }       
                        }
                    }
                }
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("<<<<<<<<<<<<<< Result >>>>>>>>>>>>>>>>");
        for(Object[] l:list) {
            for(Object l1:l) {
                System.out.print("["+l1+"]");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new ReadingFile().read();
    }
}