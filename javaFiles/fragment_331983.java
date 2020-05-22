public class Employee {

private static HashMap<String, String> employees = new HashMap<>();

public static void setEmployees(String name, String jobTitle) {
    employees.put(name, jobTitle);
    System.out.println(employees);
}

public static String getEmployees(String name){
    return employees.get(name);
}

}