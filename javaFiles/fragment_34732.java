public int compareTo(Employee emp) {
    if (this.employeeName.equals(emp.employeeName)) {
        return 0;
    }
    //removed the comparison by subtraction since it will behave wrongly on int overflow
    return new Integer(this.employeeId).compareTo(emp.employeeId);
}