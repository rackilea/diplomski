import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProgram {

    public static void main(String... args) throws Exception {
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

        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("entryList1", "customer");
        mapping.put("entryList2", "Address");

        Gson gson = new GsonBuilder().serializeNulls().setFieldNamingStrategy(new DynamicFieldNamingStrategy(mapping)).create();
        System.out.println(gson.toJson(entryListContainer));
    }
}

class DynamicFieldNamingStrategy implements FieldNamingStrategy {

    private Map<String, String> mapping;

    public DynamicFieldNamingStrategy(Map<String, String> mapping) {
        this.mapping = mapping;
    }

    @Override
    public String translateName(Field field) {
        String newName = mapping.get(field.getName());
        if (newName != null) {
            return newName;
        }

        return field.getName();
    }
}

class EntryListContainer {

    private List<Entry> entryList1;
    private List<Entry> entryList2;

    public void setEntryList1(List<Entry> entryList1) {
        this.entryList1 = entryList1;
    }

    public List<Entry> getEntryList1() {
        return entryList1;
    }

    public void setEntryList2(List<Entry> entryList2) {
        this.entryList2 = entryList2;
    }

    public List<Entry> getEntryList2() {
        return entryList2;
    }
}

class Entry {

    private int id;
    private String type;
    private String property;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}