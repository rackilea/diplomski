public class Testa {

public static void main(String[] args) {
    Date d1 = new Date(100,1,2);
    Date d2 = new Date(101,2,3);
    Date d3 = new Date(102,3,4);
    Date test = new Date(101,2,3);

    Vector<Record> primaryList = new Vector<>();
    primaryList.add(new Record(d1, new Object()));
    primaryList.add(new Record(d2, new Object()));
    primaryList.add(new Record(d3, new Object()));

    List<Record> primaryListExceptDate = primaryList.stream()
               .filter(record -> !record.getKey().equals(test))
               .collect(Collectors.toList());

    primaryListExceptDate.forEach(r -> System.out.println(r.getKey().toString()));
}

static class Record {
    Date key;
    Object value;

    public Record(Date k, Object v) {
        this.key = k;
        this.value = v;
    }

    public Date getKey() {
        return key;
    }
}
}