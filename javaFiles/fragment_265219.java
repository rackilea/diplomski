public static void display() {

StringBuilder builder = new StringBuilder();

List<Employee> filtered = Arrays.stream(employees)
                                .filter(employee -> employee.getName() == null)
                                .collect(Collectors.toList());


filtered.forEach(employee ->
    builder.append(employee.getName())
           .append("\t ")
           .append(employee.getPay())
           .append("\n "));

String output = builder.toString();
JOptionPane.showMessageDialog(null,"Staff_No       Staff_Name      Pay      \n" + output);
}