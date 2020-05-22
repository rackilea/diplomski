public class Department extends ActionSupport {

 @SuppressWarnings("rawtypes")
ArrayList deptList;
@SuppressWarnings("rawtypes")
public ArrayList getDeptList() {
    return deptList;
}

@SuppressWarnings("rawtypes")
public void setDeptList(ArrayList deptList) {
    this.deptList = deptList;
}


public String Select(){
         deptList = DBConnection.getConnection();
System.out.println("the list contains..........."+deptList);
return "checked";
}
public String execute(){
    return SUCCESS;
}

    }