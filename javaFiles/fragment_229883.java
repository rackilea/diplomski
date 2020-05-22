Iterator<Employee> myEmployeeIterator = null;

public String getEachEmployeeInstance() {
    if (myEmployeeIterator == null) 
        myEmployeeIterator = employees.iterator();

    if (myEmployeeIterator.hasNext()) {
        Employee e = myEmployeeIterator.next();
        return e.getFirstName() +"\t" + e.getLastName() +"\t"+ e.getEmployeeIDString()+"\t" + e.getPunchIn() +"\t"+ e.getPunchOut() +"\t"+ e.getDailyHours() +"\t"+ e.getWeeklyHours();  
    }

    return null;            
}