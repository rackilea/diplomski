class Employee {
    private final int id;
    private int[] hours;
    public int getTotalHours() {
        return Arrays.stream(hours).sum();
    }
}

List<Employee> employees;
Collections.sort(employees, (e1, e2) -> e1.getTotalHours() - e2.getTotalHours());