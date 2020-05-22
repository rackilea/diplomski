@XmlRootElement
public class Recipe {

private Long recipeId;

private String name;

private String description;

private List<Fixing> fixings;

public Recipe() {

}

public Recipe(Long id, String name, String description, List<Fixing> fixings) {
    super();
    this.recipeId = id;
    this.name = name;
    this.description = description;
    this.fixings = fixings;
}

public Long getRecipeId() {
    return recipeId;
}

public void setRecipeId(Long id) {
    this.recipeId = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public List<Fixing> getFixings() {
    return fixings;
}

public void setFixings(List<Fixing> fixings) {
    this.fixings = fixings;
}