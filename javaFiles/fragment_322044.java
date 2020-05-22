import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChasePdfParser {
    private static Logger logger = LoggerFactory.getLogger(ChasePdfParser.class);

    private static int FOR_TAX_YEAR = 2017;
    private static String YEAR_EXTENSION = "/" + FOR_TAX_YEAR;
    private static DateTimeFormatter check = DateTimeFormatter.ofPattern("MM/dd/uuuu");
    private static List<String> exclusions = new ArrayList<>(Arrays.asList("Payment Thank You", "AUTOMATIC PAYMENT"));

    public static List<ChaseRecord> parse(String data) {
        List<ChaseRecord> l = new ArrayList<>();
        for (String line : data.split("\n")) {
            if (line.isEmpty()) continue;
            String[] split = line.split("\\s");
            if (split == null || split.length == 0) continue;
            String test = split[0];
            if (!isMMDD(test)) continue;
            if(skip(line)) continue;
            if (split.length < 4) continue;
            ChaseRecord cr = new ChaseRecord();
            cr.date = extractDate(test);
            try {
                String last = split[split.length - 1];
                last = last.replaceAll(",", "");
                cr.amt = Double.parseDouble(last);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            cr.desc = String.join(" ", Arrays.copyOfRange(split, 1, split.length - 1));
            cr.desc = cr.desc.replaceAll("\\s\\s+", " ");
            l.add(cr);
        }
        return l;
    }

    private static boolean skip(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        for (String e : exclusions) {
            if (s.contains(e)) {
                return true;
            }
        }
        return false;
    }

    protected static LocalDate extractDate(String s) {
        if (!isMMDD(s)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(s + YEAR_EXTENSION, check);
        return localDate;
    }

    public static boolean isMMDD(String s) {
        if (s == null || s.isEmpty() || s.length() != 5) {
            return false;
        }
        try {
            s += YEAR_EXTENSION;
            LocalDate.parse(s, check);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static class ChaseRecord {
        public LocalDate date;
        public String desc;
        public Double amt;

        @Override
        public String toString() {
            return "ChaseRecord{" +
                    "date=" + date +
                    ", desc='" + desc + '\'' +
                    ", amt=" + amt +
                    '}';
        }
    }
}