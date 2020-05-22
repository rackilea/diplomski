public class RowParser {
    private static final Pattern ROW_PATTERN = Pattern.compile("name:\"([^\"]+)\";affil:([\\d.]+);aup:(\\d+);bu:(TRUE|FALSE) ?");

    public static void main(String[] args) {
        String data = "name:\"SFATG\";affil:100;aup:1;bu:FALSE name:\"SF TAC 1\";affil:29.3478;aup:19;bu:FALSE name:\"SF TAC 2\";affil:22.2222;aup:14;bu:FALSE name:\"SF TAC 3\";affil:44.4444;aup:0;bu:FALSE name:\"SF DISP 4\";affil:82.4742;aup:0;bu:TRUE \n";
        System.out.println(parseRows(data));
    }

    public static List<Row> parseRows(String data) {
        Matcher matcher = ROW_PATTERN.matcher(data);
        List<Row> rows = new ArrayList<>();
        while (matcher.find()) {
            rows.add(new Row(matcher));
        }
        return rows;
    }

    // Wrapper object for individual data rows
    public static class Row {
        private String name;
        private double affil;
        private int aup;
        private boolean bu;

        Row(Matcher matcher) {
            this.name = matcher.group(1);
            this.affil = Double.parseDouble(matcher.group(2));
            this.aup = Integer.parseInt(matcher.group(3));
            this.bu = Boolean.parseBoolean(matcher.group(4));
        }

        public String getName() {
            return name;
        }

        public double getAffil() {
            return affil;
        }

        public int getAup() {
            return aup;
        }

        public boolean isBu() {
            return bu;
        }

        @Override
        public String toString() {
            return "name:\"" + name + '"' + ";affil:" + affil + ";aup:" + aup + ";bu:" + String.valueOf(bu).toUpperCase();
        }
    }
}