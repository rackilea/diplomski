double managersTotalSalary = 0;
double adminsTotalSalary = 0;
...
int managersCount = 0;
int adminsCount = 0;
...
while(... ) {
    ...
    if ("Manager".equals(employee.getDesignation())) {
        managersCount ++;
        managersTotalSalary += employee.getSalary();
    } else if ("Admin".equals(employee.getDesignation())) {
        ....
    }
    ...
} 
//you have count and total salary, calculate average and display it.