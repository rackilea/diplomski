public void getEmployeeDetails() {

  if (count.equalsIgnoreCase("1")) {
    ....
    updateRanking(sum, employee_name);
  }
}

public void updateRanking(double actualWage, String employee_name){
    if (actualWage > maxWage) {
        maxWage = actualWage;
        maxWageEmployeeName = employee_name;
    }
    else if (actualWage < minWage) {
        minWage = actualWage;
        minWageEmployeeName = employee_name;
    }
}