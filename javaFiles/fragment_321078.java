import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Scratch {
    public static void main(String[] args) throws Exception {
        List<String> files = new ArrayList<>();
        files.add("xxxx_Contract_2.1.0.xlsx");
        files.add("xxxx_Contract_2.2.0.xlsx");
        files.add("xxxx_Contract_2.1.3.xlsx");
        files.add("xxxx_Contract_4.6.3.xlsx");
        files.add("xxxx_Contract_4.6.2.xlsx");

        Version latest = null;
        for (String file : files) {
            if (latest == null) {
                latest = new Version(file);
                continue;
            }
            Version v = new Version(file);
            if (latest.compareTo(v) < 0) {
                latest = v;
            }
        }

        System.out.println("Latest version " + latest.filename);
    }

    static class Version implements Comparable<Version> {
        private static final String VERSION_REGEX = ".*(\\d+)\\.(\\d+)\\.(\\d+).*";
        private static final Pattern REGEX;
        static {
            REGEX = Pattern.compile(VERSION_REGEX);
        }

        private String filename;
        private Integer major;
        private Integer minor;
        private Integer bug;

        public Version(String filename) throws Exception {
            Matcher m = REGEX.matcher(filename);
            if (!m.matches()) {
                throw new Exception("Invalid filename " + filename);
            }

            this.filename = filename;
            this.major = Integer.valueOf(m.group(1));
            this.minor = Integer.valueOf(m.group(2));
            this.bug =  Integer.valueOf(m.group(3));
        }

        @Override
        public int compareTo(Scratch.Version o) {
            int result = major.compareTo(o.major);
            if (result != 0) {
                return result;
            }
            result = minor.compareTo(o.minor);
            if (result != 0) {
                return result;
            }
            result = bug.compareTo(o.bug);
            return result;
        }
    }
}