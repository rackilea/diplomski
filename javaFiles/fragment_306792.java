static List<Employee> list = new ArrayList<>();

static void sortEmployees() {
    list.sort(new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }});
}