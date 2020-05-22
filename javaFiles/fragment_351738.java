if (removeTime(questionDate).equals(removeTime(today)) 
  ...

public Date removeTime(Date date) {    
    Calendar cal = Calendar.getInstance();  
    cal.setTime(date);  
    cal.set(Calendar.HOUR_OF_DAY, 0);  
    cal.set(Calendar.MINUTE, 0);  
    cal.set(Calendar.SECOND, 0);  
    cal.set(Calendar.MILLISECOND, 0);  
    return cal.getTime(); 
}