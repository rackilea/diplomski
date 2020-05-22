public static List<Employee> getEmployeeListFromPersonList(List<Person> list) {
    List<Employee> res = new ArrayList<>();
    for (Person p : list) {                 // 1.Iterate
        if (p instanceof Employee) {        // 2.Check type
            res.add((Employee) p);          // 3.Cast and keep it
        }
    }
    return res;
}