@Override
    public int compareTo(Date o) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(this.date);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(o);

    int month1 = cal1.get(Calendar.MONTH); 
    int month2 = cal2.get(Calendar.MONTH);

    if(month1 < month2) 
      return -1;
    else if(month1 == month2) 
      return cal1.get(Calendar.DAY_OF_MONTH) - cal2.get(Calendar.DAY_OF_MONTH);

    else return 1; 

  }