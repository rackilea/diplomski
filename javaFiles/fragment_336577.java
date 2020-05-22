import java.util.ArrayList;

public class Day {
private ArrayList<Meal> meals = new ArrayList<>();

public Day(Meal...meals){
    //This uses magic params to allow you to pass in as many meals as you want.
    for(Meal meal : meals){
        this.meals.add(meal);
    }
}

public ArrayList<Meal> getMeals() {
    return meals;
}
}