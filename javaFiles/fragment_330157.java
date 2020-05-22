@XmlRootElement(name="insertedRecord")
public class InsertedResponse extends ResponseResult{

    ...

    public void setInsertedRecords(String insertedRecord) {            
        this.insertedRecord = insertedRecord;
    }