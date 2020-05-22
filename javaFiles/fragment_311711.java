import java.util.List;
 import org.codehaus.jackson.annotate.JsonProperty;
 public class InList {  
@JsonProperty("inList")
private List<InListDetail> inList;
public List<InListDetail> getInList() {
    return inList;
}
public void setInList(List<InListDetail> inList) {
    this.inList = inList;
}
}

import org.codehaus.jackson.annotate.JsonProperty;
public class InListDetail { 
@JsonProperty("cmd")
private String cmd;
@JsonProperty("name")
private String name;
@JsonProperty("pri")
private int pri;
public String getCmd() {        
       return cmd;
}
public void setCmd(String cmd) {
    this.cmd = cmd;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

public int getPri() {
    return pri;
}

public void setPri(int pri) {
    this.pri = pri;
}

}