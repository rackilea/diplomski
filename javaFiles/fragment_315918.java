public static  class EmployeeJSONObj {
    private String name;
    private List<EmployeeJSONObj> children;


    public String getName()
    {
        return name;
    }

    public String toString() {
        return "name: " + name + ", children = " + children;
    }
    public List<EmployeeJSONObj> getChildren() {
        return children;
    }
    public void setChildren(List<EmployeeJSONObj> children) {
        this.children = children;
    }

}