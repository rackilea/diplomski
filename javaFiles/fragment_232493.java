import java.time.*;

 public class Date {
     final LocalDate date;

     public Date(int day, int month, int year) {

         date = LocalDate.of(year, month, day);            
     }

     public int getYear() {
         return date.getYear();
     }

     public Month getMonth() {
         return date.getMonth();
     }

     public int getDay() {
        return date.getDayOfMonth();
     }
 }