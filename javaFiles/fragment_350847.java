import java.util.*;
import java.util.stream.Collectors;

public class SFO_Recursive {
    public enum Animal {
        CAT, DOG ;
    }
    public enum Food {
        FISH, BEEF, PORK ;
    }

    private static Set<Map<Animal, Food>> eats(List<Animal> animal, List<Food> food) {
        Set<Map<Animal,Food>> fleet = new HashSet();
        for (Animal a: animal){
            for (Food f: food){
                // Take a step with (a, f)
                List<Food> food_left = food.stream().filter(x -> !x.equals(f)).collect(Collectors.toList());
                List<Animal> animal_left = animal.stream().filter(x -> !x.equals(a)).collect(Collectors.toList());
                if (animal_left.isEmpty() || food_left.isEmpty()){
                    // Terminal state
                    fleet.add(new HashMap<Animal, Food>(){{put(a,f);}});
                }else {
                    eats(animal_left, food_left).stream().forEach(s -> {s.put(a, f); fleet.add(s); });
                }
            }
        }
        return fleet;
    }

    public static void main(String[] args){
        SFO_Recursive.eats(
            Arrays.asList(Animal.CAT, Animal.DOG),
            Arrays.asList(Food.BEEF, Food.FISH, Food.PORK)
        ).stream().forEach(System.out::println);
    }
}