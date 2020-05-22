public static Employee[] sum(int[][] total){
    Employee[] totaled = new Employee[8];
    for (int i = 0; i < total.length; i++)
        Employee[i].employeeNo = i+1;
        for (int j = 0; j < total[i].length; j++)
            Employee[i].totalHours += total[i][j];
return totaled;
}