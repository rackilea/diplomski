public class EmployeeManager {

    private Map<Integer, Employee> employees;

    public EmployeeManager() throws IOException {
        employees = new HashMap<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(new File("NewEmployee8.txt")))) {
            String text = null;
            while ((text = br.readLine()) != null) {
                Employee emp = new Employee(text);
                employees.put(emp.getId(), emp);
            }
        }
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(new ArrayList<Employee>(employees.values()));
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

}