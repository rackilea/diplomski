Employee oldest = employeeSet.get(0); // Initialize with the first index
for (Employee emp : employeeSet) {
    if (emp.age > oldest.age) {
        oldest = emp;
    }
}