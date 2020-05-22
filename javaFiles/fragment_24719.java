import javax.xml.bind.annotation.XmlAccessType;
    import javax.xml.bind.annotation.XmlAccessorType;
    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlRootElement;
    import java.util.List;
    @XmlRootElement(name = "myOrg")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class MyOrganisation {
        @XmlElement(name = "departmentName")
        public String departmentName;
        @XmlElement(name = "employeeID")
        public int employeeID;
        @XmlElement(name = "employeeName")
        public String employeeName;
        @XmlElement(name = "tasks")
        public List<String> tasks;

        public MyOrganisation() {
        }

        public MyOrganisation(String departmentName, int employeeID, String employeeName, List<String> tasks) {
            this.departmentName = departmentName;
            this.employeeID = employeeID;
            this.employeeName = employeeName;
            this.tasks = tasks;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public List<String> getTasks() {
            return tasks;
        }

        public void setTasks(List<String> tasks) {
            this.tasks = tasks;
        }
    }
_______