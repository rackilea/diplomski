@ElementCollection(targetClass = Ingredient.class)
private Set<Ingredient> ingredients = new HashSet<>(0);    
 ....        
@ManyToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
@JoinTable(name = "ingredient_meal", joinColumns = {@JoinColumn(name = "meal_id")}, inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
public List<Ingredient> getIngredients() {
    return ingredients;
}