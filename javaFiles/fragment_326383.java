ArrayList uniqueDate = new ArrayList<String>();
ArrayList averageValue = new ArrayList<Integer>();
LinkedHashMap store = new LinkedHashMap<String, CountEntry>();

class CountEntry {
    int value;
    int count;

    CountEntry() {
    }

    CountEntry(int v, int c) {
        value = v;
        count = c;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

public void createList(ArrayList<String> date, ArrayList<Integer> value) {
    for (int i = 0; i < date.size(); i++) {
        CountEntry tmp = (CountEntry) store.get(date.get(i));

        if (tmp == null) {
            store.put(date.get(i), new CountEntry(value.get(i), 1));
        } else {
            int tmpVal = tmp.getValue();
            int tmpCount = tmp.getCount();
            store.put(date.get(i), new CountEntry(value.get(i) + tmpVal, ++tmpCount));
        }
    }

    ArrayList<String> uniqueDate = new ArrayList<String>(store.keySet());
    ArrayList<CountEntry> tempAvgList = new ArrayList<CountEntry>(store.values());

    for (CountEntry ce : tempAvgList) {

        averageValue.add(ce.getValue() / ce.getCount());

    }
    System.out.println("Output");
    System.out.println(uniqueDate);
    System.out.println(averageValue);
}