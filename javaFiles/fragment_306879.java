class DateHolder {
      public final Date date;
      DateHolder(Date date) {
           this.date = date:
      }
 }

 // ...

 DateHolder holder = new DateHolder(Date.now());

 // this doesn't work because date is final:
 //holder.date = new Date(2013, 11, 23);

 // but this works even though date is final:
 holder.date.setYear(2013);