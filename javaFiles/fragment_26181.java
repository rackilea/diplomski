public static List<Employee> getEmployees()
{ 
    List<Employee> col = new ArrayList<Employee>();
    Calenader cal1 = Calendar.getInstance();
    cal1.set(1986, 6, 12);
    Calenader cal2 = Calendar.getInstance();
    cal2.set(1986, 6, 12);
    col.add(new Employee(5, "xyz","abc", cal1, cal2));
    return col;
}