public boolean isValid(int d, int m, int y){
    //since month is 0 based
    m--;
    //initilizes the calendar instance, by default the current date
    Calendar cal = Calendar.getInstance();
    //resetting the date to the one passed
    cal.set(Calendar.YEAR, y);
    cal.set(Calendar.MONTH, m);
    cal.set(Calendar.DATE, d);

    //now check if it is the same as we set then its valid, not otherwise
    if(cal.get(Calendar.DATE)==d &&cal.get(Calendar.MONTH) ==m && cal.get(Calendar.YEAR) ==y){
      return true;
    }
    //changed so not valid 
    return false;

}