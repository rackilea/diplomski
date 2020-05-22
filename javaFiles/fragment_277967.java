public class Record implements Comparable<Record> {
    private int index;
    private String value;

    public Record(int index, String value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Record o) {
        return index - o.index;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        String t1 = "I saw Bob, and also Mary, John's sister.";
        int[][] pos1 = { { 6, 9 }, { 20, 39 }, { 26, 30 }, { 26, 30 } };

        List<Record> records = new ArrayList<>();
        for (int i = 0; i < pos1.length; i++) {
            records.add(new Record(pos1[i][0], "["));
            records.add(new Record(pos1[i][1], "]"));
        }

        Collections.sort(records);

        StringBuilder result = new StringBuilder();
        int firstIndex = 0;
        for (Record r : records) {
            result.append(t1.substring(firstIndex, r.getIndex())).append(
                    r.getValue());
            firstIndex = r.getIndex();
        }
        result.append(t1.substring(firstIndex));
        System.out.println(result);
    }
}