public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    public String empfname;
    public String emplname;

    public String getEmpfname() {
        return empfname;
    }

    public void setEmpfname(String empfname) {
        this.empfname = empfname;
    }

    public String getEmplname() {
        return emplname;
    }

    public void setEmplname(String emplname) {
        this.emplname = emplname;
    }

    public Emp(String fn, String ln) {
        this.empfname = fn;
        this.emplname = ln;
    }

    /**
     * default constructor
     */
    public Emp() {

    }

    @Override
    public String toString() {
        return "Emp {empfname=" + empfname + ", emplname=" + emplname + "}";
    }
}