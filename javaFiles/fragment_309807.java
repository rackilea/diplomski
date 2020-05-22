ArrayList<Employee> list; // This is initialized and has Employees

for (Employee person: list) {
    if (person instanceof Admin) {
        int fixedBonus = ((Admin) person).getFixedBonus();

        // Do something here
    }
}