public static void main(String[] args) {
    Scanner key = new Scanner(System.in);

    Set<Employee> empSet = new HashSet<>(Arrays.asList(//
            new Employee(101, 2, 3, "John", "Joe"), //
            new Employee(102, 5, 6, "Phil", "Jognson"), //
            new Employee(103, 4, 7, "Billy", "Schmitz"), //
            new Employee(104, 3, 3, "Hank", "Dugart"), //
            new Employee(105, 1, 2, "Able", "Philstein"), //
            new Employee(106, 3, 10, "Adam", "Renolds"), //
            new Employee(107, 1, 4, "Larry", "Cableguy"), //
            new Employee(108, 5, 2, "Doug", "Dougster"), //
            new Employee(109, 2, 3, "Mylan", "Ester"), //
            new Employee(110, 5, 6, "Cherry", "Jakesn"), //
            new Employee(111, 2, 3, "Ethel", "Manfred"), //
            new Employee(112, 3, 11, "Lindsey", "Joel"), //
            new Employee(113, 1, 1, "Ellie", "Winston"), //
            new Employee(114, 4, 6, "Blake", "Wiotell"), //
            new Employee(115, 1, 3, "Elton", "John"), //
            new Employee(116, 2, 7, "David", "Flint"), //
            new Employee(117, 4, 600000, "Igor", "TheElder"), //
            new Employee(118, 5, 9, "Hanz", "Joe"), //
            new Employee(119, 2, 3, "Jordan", "Friedel"), //
            new Employee(120, 2, 3, "Dyaln", "Rogers")));
    while (true) {
        menus();
        int choice = key.hasNextInt() ? key.nextInt() : 6;
        if (choice == 6) {
            break;
        }
        empSet.stream().filter(emp -> emp.getDepartmentID() == choice)
                .forEach(System.out::println);
    }
}