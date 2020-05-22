import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Foo4 {
   public static void main(String[] args) {
      List<Bar4> bar4List = new ArrayList<>();
      bar4List.add(new Bar4("Donald", 3, "A", 22.42));
      bar4List.add(new Bar4("Duck", 100, "B", Math.PI));
      bar4List.add(new Bar4("Herman", 20, "C", Math.sqrt(20)));

      String titleTemplate = "%-10s %6s %6s %9s%n";
      String template = "%-10s %6d %6s %9s%n";

      System.out.printf(titleTemplate, "Name", "Value", "Grade", "Cost");
      for (Bar4 bar4 : bar4List) {
         System.out.printf(template, bar4.getName(), 
               bar4.getValue(), bar4.getGrade(), bar4.getCostString());
      }

   }
}

class Bar4 {
   private String name;
   private int value;
   private String grade;
   private double cost;
   private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

   public Bar4(String name, int value, String grade, double cost) {
      this.name = name;
      this.value = value;
      this.grade = grade;
      this.cost = cost;
   }

   public String getName() {
      return name;
   }

   public int getValue() {
      return value;
   }

   public String getGrade() {
      return grade;
   }

   public double getCost() {
      return cost;
   }

   public String getCostString() {
      return currencyFormat.format(cost);
   }

}