public class TrackBook {
@SerializedName("traceback")
@Expose
private List<String> traceback = null;
@SerializedName("ename")
@Expose
private String ename;
@SerializedName("evalue")
@Expose
private String evalue;

public List<String> getTraceback() {
    return traceback;
}

public void setTraceback(List<String> traceback) {
    this.traceback = traceback;
}

public String getEname() {
    return ename;
}

public void setEname(String ename) {
    this.ename = ename;
}

public String getEvalue() {
    return evalue;
}

public void setEvalue(String evalue) {
    this.evalue = evalue;
}
}