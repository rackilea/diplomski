public class Instructor extends Person {
    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    private String iname;

    public Instructor(Person p, String myinstructor) {
        super(p);
        this.iname = myinstructor;
    }

    public Instructor(Instructor clone) {
        super(clone);
        this.iname = clone.iname;
    }
}