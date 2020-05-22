public int searchEmployee(String lastN) {
    int noName = 0;
    int lastNIndex = 0;

    for (int i = 0; i < employeeList.size(); i++) {

        if (employeeList.get(i).getLastName().equalsIgnoreCase(lastN)) {
            lastNIndex = i;
        } else {
            i = noName;
        }
    }
}