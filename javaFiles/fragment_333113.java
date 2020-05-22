// Java 8
public class EnumTest {
    public static void main(String args[]) {
        System.out.println(parse("ABC", RecordType1.class));
        System.out.println(parse("ABCDEF", RecordType2.class));
    }

    private interface RecordLayout {
        public int length();

        public static <E extends Enum<E> & RecordLayout> int getTotalLength(Class<E> e) {
            int total = 0;
            for (E e1 : e.getEnumConstants()) {
                total += e1.length();
            }
            return total;
        }
    }

    private enum RecordType1 implements RecordLayout {
        FIELD1(2),
        FIELD2(1),;
        private int length;

        private RecordType1(int length) {
            this.length = length;
        }

        public int length() {
            return length;
        }
    }

    private enum RecordType2 implements RecordLayout {
        FIELD1(5),
        FIELD2(1),;
        private int length;

        private RecordType2(int length) {
            this.length = length;
        }

        public int length() {
            return length;
        }
    }

    private static <E extends Enum<E> & RecordLayout> String parse(String data, Class<E> record) {
        int len = RecordLayout.getTotalLength(record);
        String results = "<RECORD length=\"" + len + "\">\n";
        int curPos = 0;
        for (E field : record.getEnumConstants()) {
            int endPos = curPos + field.length();
            results += "  <" + field.toString() + ">"
                    + data.substring(curPos, endPos)
                    + "</" + field.toString() + ">\n";
            curPos = endPos;
        }
        results += "</RECORD>\n";
        return results;
    }
}