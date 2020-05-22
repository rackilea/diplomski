void incrementDate(){
    if((day + 1) > getMaxDaysInMonth())
    {
        day = 1;        
        if (month == 12)
        {
            month = 1;
            year++;
        }else{   
          month++;
    }
    } else {
       day++;
    }    
}