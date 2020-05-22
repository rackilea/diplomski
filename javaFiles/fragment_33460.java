import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class FormatExample {
   public static void main(String[] args) {
      List<FormatExData> data = new ArrayList<>();
      data.add(new FormatExData("42345", "Max", "Bruch", 40, 21.5));
      data.add(new FormatExData("23456", "Eddie", "Elgar", 43, 20));
      data.add(new FormatExData("1111", "John", "Bach", 30, 30));
      data.add(new FormatExData("00001", "Donald", "Duck", 50, 40));
      data.add(new FormatExData("99999", "Mickey", "Mouse", 20, 15));
      data.add(new FormatExData("666", "Satan", "Mephistopheles", 100, 100));

      for (FormatExData datum : data) {
         System.out.println(datum);
      }
   }
}

class FormatExData {
   private String id;
   private String firstName;
   private String lastName;
   private double hours;
   private double rate;

   public FormatExData(String id, String firstName, String lastName,
         double hours, double rate) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.hours = hours;
      this.rate = rate;
   }

   public String getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public double getHours() {
      return hours;
   }

   public double getRate() {
      return rate;
   }

   public double getGross() {
      return hours * rate;
   }

   @Override
   public String toString() {
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
      StringBuilder stringBuilder = new StringBuilder();
      Formatter formatter = new Formatter(stringBuilder);
      String template = "%-7s %-15s %-10s %10.2f %10.2f %11s";
      formatter.format(template, getId(), getLastName(), getFirstName(),
            getHours(), getRate(), currencyFormat.format(getGross()));
      formatter.close();
      return stringBuilder.toString();
   }

}