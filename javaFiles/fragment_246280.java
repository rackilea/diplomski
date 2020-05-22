public class Employee implements java.io.Serializable {

private Integer eid;
private String ename;


public Integer getEid() {
    return eid;
}

public void setEid(Integer eid) {
    this.eid = eid;
}

public String getEname() {
    return ename;
}

public void setEname(String ename) {
    this.ename = ename;
}
}