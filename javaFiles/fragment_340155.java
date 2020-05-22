public class DateTimeConverter extends DateTime {
         private DateTime originalTime;

         public DateTimeConverter(DateTime originalTime) {
              this.originalTime = originalTime;
         }

         public java.util.Date getDate() {
              return new java.util.Date(this.value);
         }
   }