package test;

import java.io.*;
import java.util.*;

public class PhoneBill {

    private static String BILL_FORMAT = "%-10s $%,6.2f\n";
    private static boolean DEBUG=true;

    Map<String, List<LineItem>> accounts = new HashMap<String,List<LineItem>>();

    public void readFile(String inFileStr) {
        FileReader fReader=null;
        try {
            fReader = new FileReader(inFileStr);
            BufferedReader br = new BufferedReader(fReader);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("_") != -1)
                    continue;
                else if (!line.isEmpty()) {
                    LineItem li = new LineItem(line.trim());
                    List<LineItem> list = accounts.get(li.accNum);
                    if(list==null){
                        list = new ArrayList<LineItem>();
                        accounts.put(li.accNum, list);
                    }
                    list.add(li);
                }
            }

            br.close();
        } catch (Exception e) {
            /* Don't just swallow Exceptions. */
            e.printStackTrace();
        } finally { 
            if(fReader!=null){
                try{
                    fReader.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void processCharges() {
        StringBuffer out = new StringBuffer(100)
            .append("Invoice\n")
            .append("--------------------------\n")
            .append("Account   Amount Due \n");
        double total = 0.0;
        double lCharges = 0;

        for (String accNum:accounts.keySet()) {
            List<LineItem> account = accounts.get(accNum);
            lCharges = 10;
            for(LineItem li:account){
                lCharges += li.getCharges();
            }
            total += lCharges;
            out.append(String.format(BILL_FORMAT, accNum, lCharges));
        }

        out.append("--------------------------\n");
        out.append(String.format(BILL_FORMAT, "Total", total));
        writeToFile("invoice.txt", out.toString());

    }

    private void writeToFile(String filename, String outStr) {
        if(DEBUG){
            System.out.printf("========%swriteToFile:%s=========\n", '=', filename);
            System.out.println(outStr);
            System.out.printf("========%swriteToFile:%s=========\n", '/', filename);
        }
        try {
            File file = new File(filename);

            // If file doesn't exist, then create it.
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(outStr);
            bw.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public static void main(String[] args) {
        PhoneBill pB = new PhoneBill();
        pB.readFile("input_data.txt");
        pB.processCharges();
    }

    static class LineItem {
        String accNum;
        double timeOfCall;
        double mins;
        double amountDue;
        boolean counted = false;

        private static final double EIGHT_AM = convertTime("08:00");
        private static final double TEN_PM = convertTime("22:00");

        public LineItem(String accStr) {
            processAccount(accStr);
        }

        private void processAccount(String accStr) {
            StringTokenizer st = new StringTokenizer(accStr);
            accNum = st.nextToken();
            timeOfCall = convertTime(st.nextToken());
            mins = Double.parseDouble(st.nextToken());
            if (timeOfCall > EIGHT_AM && timeOfCall < TEN_PM)
                amountDue = mins * 0.10;
            else
                amountDue = mins * 0.05;
        }

        public String getAccountNum() {
            return accNum;
        }

        public double getCharges() {
            return amountDue;
        }

        private static double convertTime(String in){
            /* Will blow up if `in` isn't given in h:m. */
            String[] h_m = in.split(":");
            return Double.parseDouble(h_m[0])*60+Double.parseDouble(h_m[1]);
        }

    }
}