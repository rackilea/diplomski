import java.util.ArrayList;

import com.google.gson.Gson;

public class JsonTest {

    public static void main(String[] main) {
        Entry entry1 = new Entry();
        entry1.setId(1);
        entry1.setType("USER");
        entry1.setProperty("Salary");
        Entry entry2 = new Entry();
        entry2.setId(2);
        entry2.setType("EMP");
        Entry entry3 = new Entry();
        entry3.setId(2);
        entry3.setType("EMP");
        entry3.setProperty("Work");
        Entry entry4 = new Entry();
        entry4.setId(2);
        entry4.setType("EMP");

        EntryListContainer entryListContainer = new EntryListContainer();
        ArrayList<Entry> entryList1 = new ArrayList<Entry>();
        ArrayList<Entry> entryList2 = new ArrayList<Entry>();

        entryList1.add(entry1);
        entryList1.add(entry2);
        entryList2.add(entry3);
        entryList2.add(entry4);

        entryListContainer.setEntryList1(entryList1);
        entryListContainer.setEntryList2(entryList2);

        String json = new Gson().toJson(entryListContainer, EntryListContainer.class);
        System.out.println(json);
    }

}