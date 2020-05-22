public class GetDataClass implements Runnable {
    private Midlet parentMidlet;
    private String URL;
    private RecordStore tempRecordStore;

public GetDataClass(Midlet parentMidlet, String URL, RecordStore tempRecordStore) {
        this.parentMidlet = parentMidlet;
        this.URL = URL;
        this.tempRecordStore = tempRecordStore;
}

public void run() {
    try {
         returnData = populateLocalRecordStore(tempRecordStore);
         parentMidlet.updateForm(returnData);
    } catch(Exception e) {
          // log and do exception handling
    }
}