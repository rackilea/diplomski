import java.util.ArrayList;

public class Control {
public static void main(String [] args){
    ArrayList<Day> days = new ArrayList<>();

    //Create your meals.
    Meal meal1 = new Meal(1, 1, 1);
    Meal meal2 = new Meal(2, 3, 4);

    //Add the meals to a day.
    Day day1 = new Day(meal1, meal2);

    //Add the day to the list of days.
    days.add(day1);

    //Getting the meal code for the first meal on the first day. This looks complex, but you would likely break it down before getting values.
    System.out.println(days.get(0).getMeals().get(0).getMealCode());
}
}