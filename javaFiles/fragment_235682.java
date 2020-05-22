import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class EntryListContainer {

    @SerializedName("Entry1")
    private ArrayList<Entry> entryList1;
    @SerializedName("Entry2")
    private ArrayList<Entry> entryList2;

    public void setEntryList1(ArrayList<Entry> entryList1) {
        this.entryList1 = entryList1;
    }

    public ArrayList<Entry> getEntryList1() {
        return entryList1;
    }

    public void setEntryList2(ArrayList<Entry> entryList2) {
        this.entryList2 = entryList2;
    }

    public ArrayList<Entry> getEntryList2() {
        return entryList2;
    }

}