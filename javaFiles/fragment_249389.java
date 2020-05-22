public class Test {

    static class Entry{
        String data1;
        Entry(String data1){
            this.data1 = data1;
        }
    }
    public static void main(String[] args) {
        List<Entry> data = new ArrayList<>();
        data.add(new Entry("somevalue"));
        data.add(new Entry("otherRandomValues"));
         String json = new Gson().toJson(data);
         System.out.println(json);
    }

}