public static void main(String[] args) {
    Employee[] arrayOfEmps = {
      new Employee(1, "Jeff Bezos")
    };
    Employee el = new Employee(11, "Bill Gates");
    List<Employee> li = new ArrayList<>(Arrays.asList(arrayOfEmps)); // to avoid read-only restriction
    li.stream().peek(s -> li.add(el)).forEach(System.out::print);
}