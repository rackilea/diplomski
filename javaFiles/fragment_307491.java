@XmlRootElement(name="departments")
public class Departments {

    List<Department> deptname;

    public List<Department> getDeptname() {
        return deptname;
    }

    public void setDeptname(List<Department> deptname) {
        this.deptname = deptname;
    }
}