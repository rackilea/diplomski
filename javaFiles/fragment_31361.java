public static void main(String args[]) {
    String str = "[{\"name\":\"3214657890RootSAPSSE\",\"children\":[{\"name\":\"672BENIAMEEN .Sales Base Market SectionCustomer Representative\"},{\"name\":\"672BENIAMEEN .Sales Base Market SectionPeão\"}]}]";
    System.out.println(str);

    Gson gson = new Gson(); 
    java.lang.reflect.Type type = new TypeToken<List<EmployeeJSONObj>>(){}.getType();
    List<EmployeeJSONObj>l = gson.fromJson(str, type);
    System.out.println(l);
}
public static  class EmployeeJSONObj {
    private String name;
    private List<EmployeeJSONObj> children = new LinkedList<>();
    EmployeeJSONObj()
    {

    }
    public String getName()
    {
        return name;
    }

    public String toString() {
        return "name: " + name + ", children = " + children;
    }

}