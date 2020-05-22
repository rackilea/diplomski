public double sueldoMedioEmpiezanPor(List<Empleado> employees, char firstword) {
    double salarySum = 0.0;
    int employeeCount = 0;
    for (Empleado employee : employees ) {
        if(firstword == employee.getNombre().charAt(0)){
            salarySum += employee.getSueldo();
            employeeCount++;
        }
    }
    return salarySum / employeeCount; 
}