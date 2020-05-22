@Autowired
BeanFactory bf;

@RequestMapping(method = RequestMethod.POST)
public @ResponseBody Something makeMeal(Meat meat) {
    bf.getBean("burger", MealStrategy.class).cookMeal(meat);
}