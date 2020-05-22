public int compare(Employee emp1, Employee emp2) {
    if(emp1.getJobTitle() == null && emp2.getJobTitle() == null){
        return 0;
    }
    if(emp1.getJobTitle() == null) return 1;
    if(emp2.getJobTitle() == null) return -1;
    return emp1.getJobTitle().compareTo(emp2.getJobTitle());
}