import java.util.ArrayList;
import java.util.List;

public class State {
   private String name;
   private List<String> cities = new ArrayList<>();

   public State(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void addCity(String city) {
      cities.add(city);
   }

   public List<String> getCities() {
      return cities;
   }

   @Override
   public String toString() {
      return "State of " + name + ", Cities: " + cities;
   }

}