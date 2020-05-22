private static Employee createEmployee(String string) {
    Employee employee = new Employee();
    employee.setEmail(string);
    return employee;
}

public static void main(String[] args)  {

    List<String> newMails = new ArrayList<>();
    List<Employee> oldList = new ArrayList<>();

    oldList.add(createEmployee("mariam.moustafa@x.com"));
    oldList.add(createEmployee("sara.ahmed@x.com"));
    oldList.add(createEmployee("ali.hassan@x.com"));
    oldList.add(createEmployee("hoosen.imam-ally@x.com"));
    oldList.add(createEmployee("allan.randall@x.com"));
    oldList.add(createEmployee("nishaan.maharaj@x.com"));

    newMails.add("ali.moustafa@x.com");
    newMails.add("sara.ahmed@x.com");
    newMails.add("emad.hamed@x.com");

    List<Employee> delete = new ArrayList<>();
    Set<String> removedMails = new HashSet<>();

    for (Employee emp : oldList) {
        if (!newMails.contains(emp.getEmail())) {
            delete.add(emp);
        }
        removedMails.add(emp.getEmail());
    }
    newMails.removeAll(removedMails);
    // remove emploeyees in delete
    oldList.removeAll(delete);

    // Create employee for left MAils
    for (String newMail : newMails) {
        oldList.add(createEmployee(newMail));
    }

    //Old and new Employees
    for (Employee emp : oldList) {
        System.out.println(emp.getEmail());
    }