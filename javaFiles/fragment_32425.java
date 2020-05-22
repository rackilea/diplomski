@Entity
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String location;

    @Id
    @GeneratedValue
    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    // ...
}