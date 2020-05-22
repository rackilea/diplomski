import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapFileReader {

    private static final String FILENAME = "D:\\ComplexMapFileReader.txt";


    private static class Record {
        private char ch;
        private int num;
        private String string;

        public void setCh(char ch) {
            this.ch = ch;
        }

        public char getCh() {
            return ch;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

    }

    public static void main(String[] args) {

        BufferedReader br;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(FILENAME));

            List<Record> records = new ArrayList<>();

            try {
                while ((sCurrentLine = br.readLine()) != null) {

                    String[] s = sCurrentLine.split(" ");

                    if (s.length != 3) {
                        // Filter invalid records
                        continue;
                    }

                    Record r = new Record();
                    r.ch = s[0].charAt(0);
                    r.num = Integer.parseInt(s[1]);
                    r.string = s[2];

                    records.add(r);
                }

                Collections.sort(records, new Comparator<Record>() {
                    @Override
                    public int compare(Record o1, Record o2) {
                        if (o1.ch == o2.ch) {
                            return o1.num < o2.num ? -1 : (o1.num == o2.num ? 0 : 1);
                        }
                        return o1.ch < o2.ch ? -1 : 1;
                    }
                });

                for (Record record : records) {
                    System.out.println(String.format("Each line equals: %s %s %s", record.ch, record.num, record.string));
                    System.out.println("#############");
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}