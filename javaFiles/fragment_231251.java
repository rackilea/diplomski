import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListGetResponse {
private List<SMSList> list;

public List<SMSList> getList() {
    return list;
}

public void setList(List<SMSList> list) {
    this.list = list;
}

@Override
public String toString() {
    return "SMSListGetResponse [list=" + list + "]";
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class SMSList {
    private String list_id = "";
    private String list_name = "";

    public String getList_id() {
        return list_id;
    }
    public void setList_id(String list_id) {
        this.list_id = list_id;
    }
    public String getList_name() {
        return list_name;
    }
    public void setList_name(String list_name) {
        this.list_name = list_name;
    }
    @Override
    public String toString() {
        return "SMSList [list_id=" + list_id + ", list_name=" + list_name
                + "]";
    }


}
}