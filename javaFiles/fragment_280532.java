@Resource(name = "burger")
MealStrategy burger;

@Resource(name = "sausage")
MealStrategy sausage;

@RequestMapping(method = RequestMethod.POST)
public @ResponseBody Something makeMeal(Meat meat) {
    burger.cookMeal(meat);
}