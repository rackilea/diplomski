public String getEachEmployeeInstance() {

    StringBuilder sb = new StringBuilder();
    for (Employee e : employees)
    {  
        sb.append(e.getFirstName() +"\t" + e.getLastName() +"\t"+ e.getEmployeeIDString()+"\t" + e.getPunchIn() +"\t"+ e.getPunchOut() +"\t"+ e.getDailyHours() +"\t"+ e.getWeeklyHours());  
        sb.append("\n");
    }         
    return sb.toString();            
}