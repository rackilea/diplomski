@Root(name = "Error")
public class Error {

    @Element(name = "Code")
    int code;

    @Element(name = "Info")
    String info;

    public Error() {
        // no arg constructor
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }
}